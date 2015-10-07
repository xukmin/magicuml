/**
 * This is the prototype of the UML Diagram Generator.
 * Just keep it for the record.
 */
package uml;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Min Xu
 *
 */
public class UmlGenerator {
  public UmlGenerator() {
  }

  public String getUmlDiagram() {
    return formatter.toString();
  }
  
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java uml.UmlGenerator <classname>...");
      return;
    }

    UmlGenerator generator = new UmlGenerator();
    
    generator.convertClasses(Arrays.asList(args));    
    System.out.print(generator.getUmlDiagram());
  }

  public void generateHeader() {
    formatter.format(
        new StringBuffer()
            .append("digraph uml_classes {\n")
            .append("  graph [\n")
            .append("    rankdir = BT;\n")
            .append("//    splines = ortho;\n")
            .append("  ];\n")
            .append("  node [\n")
            .append("    shape = plaintext\n")
            .append("    fontsize = 10\n")
            .append("    //margin = 0\n")
            .append("  ];\n")
            .toString());
  }
 
  public void generateFooter() {
    formatter.format(
        new StringBuffer()
            .append("}\n")
            .toString());
  }
  
  public void convertClass(Class<?> c) {
    System.err.println(c.getCanonicalName());
    formatter.format(
        new StringBuffer()
            .append("  \"%1$s\" [\n")
            .append("    shape = plaintext;\n")
            .append("    label = <\n")
            .append("      <table border='0' cellborder='1' cellspacing='0'>\n")
            .append("        <tr>\n")
            .append("          <td bgcolor='%3$s'>%2$s<br/>%1$s</td>\n")
            .append("        </tr>\n").toString(),
        c.getCanonicalName(),
        c.isInterface() ? "&lt;&lt;interface&gt;&gt;" : "&lt;&lt;class&gt;&gt;",
        c.isInterface() ? "yellow" : "orange");

    // add fields in class
    formatter.format(
        new StringBuffer()
            .append("       <tr>\n")
            .append("         <td>").toString());
    for (Field f : c.getDeclaredFields()) {
      formatter.format(
          new StringBuffer()
              .append("<br/>%1$s:%2$s\n").toString(),
          f.getName(),
          f.getType().getCanonicalName());
    }
    formatter.format(
        new StringBuffer()
            .append("</td>\n")
            .append("       </tr>\n").toString());
    
    //add methods in class
    formatter.format(
        new StringBuffer()
            .append("       <tr>\n")
            .append("         <td>").toString());
    for (Method f : c.getMethods()) {
      formatter.format(
          new StringBuffer()
              .append("<br/>%1$s(").toString(),
          f.getName());
      // loop for the parameters
      for (Class<?> p : f.getParameterTypes()) {
        formatter.format(
            new StringBuffer()
                .append("%1$s,").toString(),
            p.getCanonicalName());
      }
      // end loop
      formatter.format(
          new StringBuffer()
              .append("):%1$s\n").toString(),
          f.getReturnType().getCanonicalName());
    }
    formatter.format(
        new StringBuffer()
            .append("</td>\n")
            .append("       </tr>\n").toString());
    
    // end table
    formatter.format(
        new StringBuffer()
            .append("      </table>\n")
            .append("      >\n")
            .append("  ];\n")
            .toString());
  }
  
  public void addSuperClass(Class<?> c, Class<?> s) {
    formatter.format(
        "\"%s\" -> \"%s\" [ arrowhead = empty ];\n",
        c.getCanonicalName(), s.getCanonicalName());
  }
 
  public void addImplementedInterface(Class<?> c, Class<?> i) {
    formatter.format(
        "\"%s\" -> \"%s\" [ style = dashed; arrowhead = empty; ];\n",
        c.getCanonicalName(), i.getCanonicalName());
  }

  private void addToQueueIfUnvisted(Class<?> c) {
    if (!visited.contains(c)) {
      queue.add(c);
    } 
  }
  
  public void addHasARelation(Class<?> c, Class<?> fc) {
    formatter.format(
        "\"%s\" -> \"%s\" [ arrowhead = open; arrowtail = diamond; dir = both; constraint = false; ];\n",
        c.getCanonicalName(), fc.getCanonicalName());
  }
  
  public void convertClasses(Collection<String> classNames) {
    generateHeader();
    
    for (String className : classNames) {
      try {
        queue.add(Class.forName(className));
      } catch (ClassNotFoundException e) {
        System.err.println(e.getMessage());
      }
    }
    
    while (!queue.isEmpty()) {
      Class<?> c = queue.remove();
      if (!visited.add(c)) {
        continue;
      }
     
      convertClass(c);
      
      Class<?> s = c.getSuperclass();
      if (s != null && !s.equals(Object.class)) {
        addSuperClass(c, s);
        addToQueueIfUnvisted(s);
      }
      
      for (Class<?> i : c.getInterfaces()) {
        addImplementedInterface(c, i);
        addToQueueIfUnvisted(i);
      }
      
      for (Field f : c.getDeclaredFields()) {
        Class<?> fc = f.getType();
        if (fc.isPrimitive()) {
          continue;
        }
        addHasARelation(c, fc);
        addToQueueIfUnvisted(fc);
      }
    }
    
    generateFooter();
  }

  private Formatter formatter = new Formatter();
  
  private Set<Class<?>> visited = new HashSet<Class<?>>();
  private Queue<Class<?>> queue = new LinkedList<Class<?>>();
  
}
