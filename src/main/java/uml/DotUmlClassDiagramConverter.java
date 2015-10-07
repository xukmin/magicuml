package uml;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Role(role = "Adapter.ConcreteAdaptee")
public class DotUmlClassDiagramConverter implements UmlClassDiagramConverter {
  // FIXME: apply matcher.
  public DotUmlClassDiagramConverter(UmlMatcher matcher,
                                     DotUmlClassDiagramStyle style) {
    this.matcher = matcher;
    this.style = style;
  }

  public DotUmlClassDiagramConverter(Set<UmlClass> classes) {
    this(new AllUmlMatcher(), new DefaultDotUmlClassDiagramStyle());
  }

  public DotGraph getGraph() {
    return graph;
  }

  // FIXME: Map<String, UmlClass>
  @Override
  public void convertAll(List<UmlClass> classes) {
    this.classes = new TreeMap<String, UmlClass>();
    for (UmlClass c : classes) {
      this.classes.put(c.getName(), c);
    }
    
    graph = new DotGraph();
    graph.addNode(new DotNode("graph", style.getDiagramStyle()));
    currentTable = null;
    currentCell = null;
    
    UmlVisitorAdapter adapter = new UmlVisitorAdapter(new UmlClassDiagramConverterAdapter(this));

    for (UmlClass c : classes) {
      c.accept(adapter);
    }
  }
  
  @Override
  public void convert(UmlEntity e) {
  }

  @Override
  public void convert(UmlClass c) {
    superTypes = new HashSet<String>();
 
    for (UmlAnnotation a : c.getAnnotations()) {
      if (matcher.matches(a)) {
        convert(a);
      }
    }
  }

  private void convertFields(UmlClass c) {
    relatedTypes = new HashSet<String>();
    for (UmlField f : c.getFields()) {
      convert(f);
    }
  }

  private void convertMethods(UmlClass c) {
    for (UmlMethod m : c.getMethods()) {
      convert(m);
    }
  }

  private void convertClassName(String classifier, String className) {
    currentCell.addText(
        String.format("&lt;&lt;Java %s&gt;&gt;<br/>\n%s<br/>\n", classifier, className));
  }

  private void convertParents(UmlClass c) {
    String s = c.getSuperclass();
    if (s != null && classes.containsKey(s) && matcher.matches(classes.get(s))) {
      graph.addEdge(new DotEdge(c.getName(), s, style.getExtendsStyle()));
      superTypes.add(s);
    }
    for (String i : c.getSuperinterfaces()) {
      if (classes.containsKey(i) && matcher.matches(classes.get(i))) {
        graph.addEdge(new DotEdge(c.getName(), i, style.getImplementsStyle()));
        superTypes.add(i);
      }
    }
  }

  @Override
  public void convert(UmlInterface i) {
    if (!matcher.matches(i)) {
      return;
    }
    convert((UmlClass) i);
    
    currentTable = new HtmlTable(style.getInterfaceFrameStyle());

    currentCell = currentTable.addCell(style.getInterfaceNameStyle());
    convertClassName("interface", i.getName());

    convertParents(i);

    if (showFields()) {
      currentCell = currentTable.addCell(style.getInterfaceFieldStyle());
    } else {
      currentCell = new HtmlTableCell(style.getInterfaceFieldStyle());
    }
    convertFields(i);

    if (showMethods()) {
      currentCell = currentTable.addCell(style.getInterfaceMethodStyle());
    } else {
      currentCell = new HtmlTableCell(style.getInterfaceMethodStyle());
    }
    convertMethods(i);

    DotNode node = new DotNode(i.getName(), style.getInterfaceStyle());
    node.addAttribute("label", String.format("<%s>", currentTable.toString()));
    graph.addNode(node);
  }

  @Override
  public void convert(UmlAbstractClass c) {
    if (!matcher.matches(c)) {
      return;
    }
    convert((UmlClass) c);
    
    currentTable = new HtmlTable(style.getAbstractClassFrameStyle());

    currentCell = currentTable.addCell(style.getAbstractClassNameStyle());
    convertClassName("class", c.getName());

    convertParents(c);

    if (showFields()) {
      currentCell = currentTable.addCell(style.getAbstractClassFieldStyle());
    } else {
      currentCell = new HtmlTableCell(style.getAbstractClassFieldStyle());
    }
    convertFields(c);

    if (showMethods()) {
      currentCell = currentTable.addCell(style.getAbstractClassMethodStyle());
    } else {
      currentCell = new HtmlTableCell(style.getAbstractClassMethodStyle());
    }
    convertMethods(c);
    
    DotNode node = new DotNode(c.getName(), style.getInterfaceStyle());
    node.addAttribute("label", String.format("<%s>", currentTable.toString()));
    graph.addNode(node);
  }

  @Override
  public void convert(UmlConcreteClass c) {
    if (!matcher.matches(c)) {
      return;
    }
    convert((UmlClass) c);
    
    currentTable = new HtmlTable(style.getConcreteClassFrameStyle());

    currentCell = currentTable.addCell(style.getConcreteClassNameStyle());
    convertClassName("class", c.getName());

    convertParents(c);

    if (showFields()) {
      currentCell = currentTable.addCell(style.getConcreteClassFieldStyle());
    } else {
      currentCell = new HtmlTableCell(style.getConcreteClassFieldStyle());
    }
    convertFields(c);

    if (showMethods()) {
      currentCell = currentTable.addCell(style.getConcreteClassMethodStyle());
    } else {
      currentCell = new HtmlTableCell(style.getConcreteClassMethodStyle());
    }
    convertMethods(c);

    DotNode node = new DotNode(c.getName(), style.getConcreteClassStyle());
    node.addAttribute("label", String.format("<%s>", currentTable.toString()));
    graph.addNode(node);
  }

  private String getModifierSymbol(int modifiers) {
    if (Modifier.isPublic(modifiers)) {
      return "+";
    } else if (Modifier.isProtected(modifiers)) {
      return "#";
    } else if (Modifier.isPrivate(modifiers)) {
      return "-";
    } else {
      return "~";
    }
  }
  
  @Override
  public void convert(UmlField f) {
    if (!matcher.matches(f)) {
      return;
    }
    
    // TODO: Remove this hack.
    if (!f.getName().startsWith("__invisible__")) {
      currentCell.addText(String.format("%s %s:%s<br/>", getModifierSymbol(f.getModifiers()),
          f.getName(), f.getType()));
    }
    
    if (!relatedTypes.contains(f.getType()) &&
        matcher.matchesFieldType() &&
        classes.containsKey(f.getType()) &&
        matcher.matches(classes.get(f.getType()))) {
      // TODO: Remove this hack.
      DotEdge edge;
      if (f.getName().startsWith("__invisible__noconstraint__")) {
        edge = new DotEdge(f.getDeclaringClass(), f.getType(), style.getInvisibleNoConstraintStyle());
      } else if (f.getName().startsWith("__invisible__")) {
        edge = new DotEdge(f.getDeclaringClass(), f.getType(), style.getInvisibleStyle());
      } else {
        edge = new DotEdge(f.getDeclaringClass(), f.getType(), style.getContainsStyle());
      }
      graph.addEdge(edge);
      relatedTypes.add(f.getType());
    }
  }

  private static String joinWithComma(List<String> list) {
    StringBuffer buffer = new StringBuffer();
    if (!list.isEmpty()) {
      buffer.append(list.get(0));
    }
    for (int i = 1; i < list.size(); i++) {
      buffer.append(", ").append(list.get(i));
    }
    return buffer.toString();
  }

  @Override
  public void convert(UmlMethod m) {
    if (!matcher.matches(m)) {
      return;
    }
    
    List<String> parameters = m.getParameterTypes();
    currentCell.addText(
        String.format("%s %s(%s):%s<br/>",
            getModifierSymbol(m.getModifiers()), m.getName(),
            joinWithComma(parameters), m.getReturnType()));

    if (!m.getReturnType().equals(m.getDeclaringClass()) &&
        !superTypes.contains(m.getReturnType()) &&
        !relatedTypes.contains(m.getReturnType()) &&
        matcher.matchesMethodReturnType() &&
        classes.containsKey(m.getReturnType()) &&
        matcher.matches(classes.get(m.getReturnType()))) {
      graph.addEdge(new DotEdge(m.getDeclaringClass(), m.getReturnType(), style.getCreatesStyle()));
      relatedTypes.add(m.getReturnType());
    }
    for (String parameter : parameters) {
      if (!parameter.equals(m.getDeclaringClass()) &&
          !superTypes.contains(parameter) &&
          !relatedTypes.contains(parameter) &&
          matcher.matchesMethodParameterTypes() &&
          classes.containsKey(parameter) &&
          matcher.matches(classes.get(parameter))) {
        graph.addEdge(new DotEdge(m.getDeclaringClass(), parameter, style.getUsesStyle()));
        relatedTypes.add(parameter);
      }
    }
  }

  public void convert(UmlAnnotation annotation) {
    List<Role> roles = new ArrayList<Role>();
    if (annotation.getName().equals("uml.Role")) {
      roles.add(annotation.<Role>getAnnotation());
    } else if (annotation.getName().equals("uml.Roles")) {
      for (Role role : annotation.<Roles>getAnnotation().value()) {
        roles.add(role);
      }
    } else {
      return;
    }
    
    Formatter formatter = new Formatter();
    for (Role role : roles) {
      formatter.format("%s\\l", role.role().replace(":", ":\\l"));
    }
    DotNode comment = new DotNode(String.format("COMMENT.%s", annotation.getDeclaringClass()),
                                  style.getCommentStyle());
    comment.addAttribute("label", formatter.toString());
    formatter.close();
    graph.addNode(comment);
    graph.addEdge(new DotEdge(comment.getName(), annotation.getDeclaringClass(),
                              style.getCommentsStyle()));
    DotSection rank = new DotSection();
    rank.addAttribute("rank", "same");
    rank.addStatement(String.format("\"%s\"", comment.getName()));
    rank.addStatement(String.format("\"%s\"", annotation.getDeclaringClass()));
    graph.addSection(rank);
  }
  
  public boolean showFields() {
    return showFields;
  }
  
  public boolean showMethods() {
    return showMethods;
  }
  
  public void setShowFields(boolean showFields) {
    this.showFields = showFields;
  }
  
  public void setShowMethods(boolean sowMethods) {
    this.showMethods = showMethods;
  }
  
  private UmlMatcher matcher;
  private DotUmlClassDiagramStyle style;
  private Map<String, UmlClass> classes;
  private DotGraph graph;
  
  private boolean showFields = true;
  private boolean showMethods = true;
  
  private HtmlTable currentTable;
  private HtmlTableCell currentCell;
  private Set<String> superTypes;
  private Set<String> relatedTypes;
}
