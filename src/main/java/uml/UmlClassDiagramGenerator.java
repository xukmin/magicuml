package uml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

// A facade for UML class diagram generation.
@Role(role = "Facade:Facade")
public class UmlClassDiagramGenerator {
  public UmlClassDiagramGenerator() {
    builder = new CanonicalUmlClassDiagramBuilder();
    style = new ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette.YELLOW_HEADER);    
  }
  
  public String generate(Collection<String> classNames, String basename)
      throws IOException {
    if (matcher == null) {
      /*
      matcher =
          new AndUmlMatcher(
              new AndUmlMatcher(
                  UmlPackageMatcher.createFromClasses(classNames),
                  new UmlPublicMatcher()),
              new UmlMethodTypesFilter());
              */
      /*
      matcher =
          new AndUmlMatcher(
              UmlPackageMatcher.createFromClasses(classNames));
              new UmlMethodParameterTypesFilter());
              */
      matcher = UmlPackageMatcher.createFromClasses(classNames);
    }
    
    JavaClassesConverter javaClassesConverter = new JavaClassesConverter(matcher, builder);
    javaClassesConverter.convertClassNames(classNames);
    List<UmlClass> classes = builder.getClasses();
   
    DotUmlClassDiagramConverter dotConverter = new DotUmlClassDiagramConverter(matcher, style);
    
    dotConverter.convertAll(classes);
    DotGraph graph = dotConverter.getGraph();
   
    String directory = "/tmp/uml";
    new File(directory).mkdirs();
    
    String dotFilename = String.format("%s/%s.dot", directory, basename);
    try (FileWriter writer = new FileWriter(dotFilename)) {
      writer.write(graph.toString());
    }
    GraphViz graphViz = new GraphViz();
    String graphFilename = graphViz.generateGraph(dotFilename, directory, outputFormat);
    return graphFilename;
  }

  public void generateAndOpen(Collection<String> classNames, String basename)
      throws IOException {
    String graphFilename = generate(classNames, basename);
    GraphViewer viewer = new GraphViewer(); 
    viewer.open(graphFilename);
  }
  
  public void generate(Collection<String> classNames) throws IOException {
    generateAndOpen(classNames, "uml");
  }
  
  public UmlMatcher getUmlMatcher() {
    return matcher;
  }
  
  public void setUmlMatcher(UmlMatcher matcher) {
    this.matcher = matcher;
  }
  
  /**
   * @return the style
   */
  public DotUmlClassDiagramStyle getStyle() {
    return style;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(DotUmlClassDiagramStyle style) {
    this.style = style;
  }
  
  /**
   * @return the outputFormat
   */
  public String getOutputFormat() {
    return outputFormat;
  }

  /**
   * @param outputFormat the outputFormat to set
   */
  public void setOutputFormat(String outputFormat) {
    this.outputFormat = outputFormat;
  }

  private CanonicalUmlClassDiagramBuilder builder;
  private UmlMatcher matcher;
  private DotUmlClassDiagramStyle style;
  private String outputFormat = "svg";
  
  private GraphViz graphViz = null;
  private GraphViewer graphViewer = null;
  private DotUmlClassDiagramConverter converter = null;
}
