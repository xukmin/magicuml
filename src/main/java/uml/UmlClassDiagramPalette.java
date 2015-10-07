package uml;

public class UmlClassDiagramPalette {
  public UmlClassDiagramPalette(String interfaceNameColor,
                                String interfaceFieldColor,
                                String interfaceMethodColor,
                                String abstractClassNameColor,
                                String abstractClassFieldColor,
                                String abstractClassMethodColor,
                                String concreteClassNameColor,
                                String concreteClassFieldColor,
                                String concreteClassMethodColor) {
    this.interfaceNameColor = interfaceNameColor;
    this.interfaceFieldColor = interfaceFieldColor;
    this.interfaceMethodColor = interfaceMethodColor;
    this.abstractClassNameColor = abstractClassNameColor;
    this.abstractClassFieldColor = abstractClassFieldColor;
    this.abstractClassMethodColor = abstractClassMethodColor;
    this.concreteClassNameColor = concreteClassNameColor;
    this.concreteClassFieldColor = concreteClassFieldColor;
    this.concreteClassMethodColor = concreteClassMethodColor;
  }

  public String getInterfaceNameColor() {
    return interfaceNameColor;
  }

  public String getInterfaceFieldColor() {
    return interfaceFieldColor;
  }

  public String getInterfaceMethodColor() {
    return interfaceMethodColor;
  }

  public String getAbstractClassNameColor() {
    return abstractClassNameColor;
  }

  public String getAbstractClassFieldColor() {
    return abstractClassFieldColor;
  }

  public String getAbstractClassMethodColor() {
    return abstractClassMethodColor;
  }

  public String getConcreteClassNameColor() {
    return concreteClassNameColor;
  }

  public String getConcreteClassFieldColor() {
    return concreteClassFieldColor;
  }

  public String getConcreteClassMethodColor() {
    return concreteClassMethodColor;
  }

  public static UmlClassDiagramPalette createSolidPalette(
      String interfaceColor,
      String abstractClassColor,
      String concreteClassColor) {
    return new UmlClassDiagramPalette(
        interfaceColor, interfaceColor, interfaceColor,
        abstractClassColor, abstractClassColor, abstractClassColor,
        concreteClassColor, concreteClassColor, concreteClassColor);
  }

  public static UmlClassDiagramPalette createHeaderPalette(
      String interfaceNameColor,
      String abstractClassNameColor,
      String concreteClassNameColor) {
    return new UmlClassDiagramPalette(
        interfaceNameColor, "#FFFFFF", "#FFFFFF",
        abstractClassNameColor, "#FFFFFF", "#FFFFFF",
        concreteClassNameColor, "#FFFFFF", "#FFFFFF");
  }

  private String interfaceNameColor;
  private String interfaceFieldColor;
  private String interfaceMethodColor;
  private String abstractClassNameColor;
  private String abstractClassFieldColor;
  private String abstractClassMethodColor;
  private String concreteClassNameColor;
  private String concreteClassFieldColor;
  private String concreteClassMethodColor;

  // Color Palette: https://www.google.com/design/spec/style/color.html#color-color-palette
  public static final UmlClassDiagramPalette YELLOW =
      createSolidPalette("#FFF9C4", "#FFF9C4", "#FFF9C4");  // Yellow 100

  public static final UmlClassDiagramPalette YELLOW_HEADER =
      createHeaderPalette("#FFEA00", "#FFC400", "#FF9100");  // Yellow A400

  public static final UmlClassDiagramPalette YELLOW_THEME =
      new UmlClassDiagramPalette("#FFD600", "#FFEA00", "#FFFF00",  // Yellow A700, A400, A200
                                 "#FFAB00", "#FFC400", "#FFD740",
                                 "#FF6D00", "#FF9100", "#FFAB40");

  public static final UmlClassDiagramPalette CYAN =
      createSolidPalette("#B3E5FC", "#B2EBF2", "#B2DFDB");  // Cyan 100

  public static final UmlClassDiagramPalette CYAN_HEADER =
      createHeaderPalette("#00B0FF", "#00E5FF", "#1DE9B6");  // Cyan A400
  
  public static final UmlClassDiagramPalette CYAN_THEME =
      new UmlClassDiagramPalette("#0091EA", "#00B0FF", "#40C4FF",  // Cyan A700, A400, A200
                                 "#00B8D4", "#00E5FF", "#1DE9B6",
                                 "#40C4FF", "#18FFFF", "#64FFDA");

  public static final UmlClassDiagramPalette BLUE =
      createSolidPalette("#D1C4E9", "#C5CAE9", "#BBDEFB");  // Blue 100

  public static final UmlClassDiagramPalette BLUE_HEADER =
      createHeaderPalette("#651FFF", "#3D5AFE", "#2979FF");  // Blue A400

  public static final UmlClassDiagramPalette BLUE_THEME =
      new UmlClassDiagramPalette("#6200EA", "#651FFF", "#7C4DFF",  // Blue A700, A400, A200
                                 "#304FFE", "#3D5AFE", "#536DFE",
                                 "#2962FF", "#2979FF", "#448AFF");

  public static final UmlClassDiagramPalette RED =
      createSolidPalette("#FFCDD2", "#F8BBD0", "#E1BEE7");  // Red 100

  public static final UmlClassDiagramPalette RED_HEADER =
      createHeaderPalette("#FF1744", "#F50057", "#D500F9");  // Red A400

  public static final UmlClassDiagramPalette RED_THEME =
      new UmlClassDiagramPalette("#D50000", "#FF1744", "#FF5252",  // Red A700, A400, A200
                                 "#C51162", "#F50057", "#FF4081",
                                 "#AA00FF", "#D500F9", "#E040FB");
}

