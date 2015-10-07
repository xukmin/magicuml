package uml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/*
 * This class is a thin wrapper over the GraphViz command line tool.
 */
public class GraphViz {
  String generateGraph(String inputFilename, String outputDirectory, String format) {
    String basename = getBasename(inputFilename);
    String outputFilename =
        Paths.get(outputDirectory, String.format("%s.%s", basename, format)).toString();
   
    String graphviz = System.getProperty("uml.graphviz.dot");
    if (graphviz == null) {
      graphviz = GRAPHVIZ_DOT;
    }
    ProcessBuilder builder = new ProcessBuilder(
        graphviz,
        inputFilename,
        "-o", outputFilename,
        String.format("-T%s", format),
        format.equals("svg") ? "" : "-Gdpi=300");
    File log = new File("/tmp/dot.stderr");
    builder.redirectError(log);
    try {
      Process p = builder.start();
      p.waitFor();
    } catch (IOException | InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return outputFilename;
  }
  
  private String getBasename(String filename) {
    int slash = filename.lastIndexOf('/');
    int dot = filename.lastIndexOf('.');
    if (dot < slash) {
      dot = filename.length();
    }
    return filename.substring(slash, dot);
  }
  
  private static String GRAPHVIZ_DOT = "/opt/local/bin/dot";
}
