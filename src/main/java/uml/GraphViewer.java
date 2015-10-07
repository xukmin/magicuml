package uml;

import java.io.IOException;

public class GraphViewer {
  void open(String filename) {
    ProcessBuilder builder = new ProcessBuilder("open", filename);
    try {
      Process p = builder.start();
      p.waitFor();
    } catch (IOException | InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
