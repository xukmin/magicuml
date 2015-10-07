package uml;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UmlClassesConverterText {
  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void test() throws IOException {
    builder = new CanonicalUmlClassDiagramBuilder();
    javaClassesConverter = new JavaClassesConverter(
        //new AllUmlMatcher(),
        new AndUmlMatcher(
            new AndUmlMatcher(
                new UmlPackageMatcher("java.util"),
                new UmlFieldTypeFilter()),
            new UmlMethodTypesFilter()),
        builder);
    
    javaClassesConverter.convertClassNames(Arrays.asList("java.util.LinkedList"));
    /*
    javaClassesConverter.convertClassNames(Arrays.asList(
        "patterns.abstractfactory.Customer",
        "patterns.abstractfactory.Creator",
        "patterns.abstractfactory.ConcreteCreator1",
        "patterns.abstractfactory.ConcreteCreator2",
        "patterns.abstractfactory.ProductA1",
        "patterns.abstractfactory.ProductA2",
        "patterns.abstractfactory.ProductB1",
        "patterns.abstractfactory.ProductB2"));
        */
    List<UmlClass> classes = builder.getClasses();
   
    System.out.println("size = " + classes.size());
    for (UmlClass c : classes) {
      System.out.println("class " + c.getName());
    }
    
    DotUmlClassDiagramConverter dotConverter =
        new DotUmlClassDiagramConverter(
            //new UmlPackageMatcher("patterns.abstractfactory"),
            new AndUmlMatcher(
                new UmlPublicMatcher(),
                new AndUmlMatcher(
                    new AndUmlMatcher(
                        new UmlPackageMatcher("java.util"),
                        new UmlFieldTypeFilter()),
                    new UmlMethodParameterTypesFilter())),
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_THEME));
    
    dotConverter.convertAll(classes);
    try (FileWriter writer = new FileWriter("/tmp/java.util.LinkedList.dot")) {
      writer.write(dotConverter.getGraph().toString());
    }
  }

  @Test
  public void testAbstractFactoryPattern() throws IOException {
    builder = new CanonicalUmlClassDiagramBuilder();
    javaClassesConverter = new JavaClassesConverter(
        new AllUmlMatcher(),
        builder);
    
    javaClassesConverter.convertClassNames(Arrays.asList(
        "patterns.abstractfactory.Client",
        "patterns.abstractfactory.ConcreteFactory1",
        "patterns.abstractfactory.ConcreteFactory2"));
    List<UmlClass> classes = builder.getClasses();
   
    System.out.println("size = " + classes.size());
    for (UmlClass c : classes) {
      System.out.println("class " + c.getName());
    }
    
    DotUmlClassDiagramConverter dotConverter =
        new DotUmlClassDiagramConverter(
            new UmlPackageMatcher("patterns.abstractfactory"),
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER));
    
    dotConverter.convertAll(classes);
    try (FileWriter writer = new FileWriter("/tmp/AbstractFactoryPattern.dot")) {
      writer.write(dotConverter.getGraph().toString());
    }
  }

  @Test
  public void testUmlClassDiagramConverter() throws IOException {
    Collection<String> initialClasses =
        Arrays.asList(
            "uml.DotUmlClassDiagramConverter",
            "uml.UmlClassDiagramConverter"
            );
    
    CanonicalUmlClassDiagramBuilder builder = new CanonicalUmlClassDiagramBuilder();
    JavaClassesConverter javaClassesConverter = new JavaClassesConverter(
        new UmlClassMatcher(initialClasses),
        builder);
    
    javaClassesConverter.convertClassNames(initialClasses);
    List<UmlClass> classes = builder.getClasses();
   
    System.out.println("size = " + classes.size());
    for (UmlClass c : classes) {
      System.out.println("class " + c.getName());
    }
    
    DotUmlClassDiagramConverter dotConverter =
        new DotUmlClassDiagramConverter(
            new UmlClassMatcher(initialClasses),
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER));
    
    dotConverter.convertAll(classes);
    try (FileWriter writer = new FileWriter("/tmp/uml.dot")) {
      writer.write(dotConverter.getGraph().toString());
    }
  }
 
  @Test
  public void testJavaClassesConverter() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.JavaClassesConverter",
        "uml.UmlEntity",
        "uml.UmlClass",
        "uml.UmlInterface",
        "uml.UmlAbstractClass",
        "uml.UmlConcreteClass",
        "uml.UmlField",
        "uml.UmlMethod",
        "uml.UmlClassDiagramBuilder",
        "uml.CanonicalUmlClassDiagramBuilder");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(new UmlClassMatcher(classes));
    generator.generate(classes, "JavaClassesConverter-BuilderPattern");
  }
  
  @Test
  public void testGenerateUmlEntity() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.UmlEntity",
        "uml.UmlClass",
        "uml.UmlInterface",
        "uml.UmlAbstractClass",
        "uml.UmlConcreteClass",
        "uml.UmlField",
        "uml.UmlMethod");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
                new UmlClassMatcher(classes));
                //new UmlMethodTypesFilter()));
    generator.generate(classes, "UmlEntity");
  }

  @Test
  public void testJavaClassesCompositePattern() throws IOException {
    List<String> classes = Arrays.asList(
        "java.lang.Class",
        "java.lang.reflect.Field",
        "java.lang.reflect.Constructor",
        "java.lang.reflect.Method",
        "java.lang.reflect.Member",
        "java.lang.reflect.AccessibleObject");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
        new AndUmlMatcher(
            new UmlClassMatcher(classes),
            new UmlPublicMatcher()));
    generator.setStyle(
        new ColoredDotUmlClassDiagramStyle(
            UmlClassDiagramPalette.CYAN_HEADER,
            new DefaultDotUmlClassDiagramStyle()));
    generator.generate(classes, "JavaClasses-CompositePattern");
  }
  
  @Test
  public void testUmlEntityCompositePattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.UmlEntity",
        "uml.UmlClass",
        "uml.UmlInterface",
        "uml.UmlAbstractClass",
        "uml.UmlConcreteClass",
        "uml.UmlField",
        "uml.UmlMethod",
        "uml.MutableUmlAbstractClass",
        "uml.MutableUmlEntity",
        "uml.MutableUmlMethod",
        "uml.MutableUmlClass",
        "uml.MutableUmlField",
        "uml.MutableUmlConcreteClass",
        "uml.MutableUmlInterface");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
                new UmlClassMatcher(classes));
                //new UmlMethodTypesFilter()));
    generator.generate(classes, "UmlEntity-CompositePattern");
  }
  
  @Test
  public void testUmlVisitorPattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.GenericUmlVisitor",
        "uml.UmlVisitor",
        "uml.UmlVisitorAdapter",
        "uml.UmlClassDiagramConverter",
        "uml.DotUmlClassDiagramConverter",
        "uml.UmlClassDiagramConverterAdapter");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.generate(classes, "visitor");
  }

  @Test
  public void testUmlClassDiagramBuilderBuilderPattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.JavaClassesConverter",
        "uml.UmlClassDiagramBuilder",
        "uml.CanonicalUmlClassDiagramBuilder");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.generate(classes, "UmlClassDiagramBuilder-BuilderPattern");
  }

  @Test
  public void testDotGraphCompositePattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.DotElement",
        "uml.DotGraph",
        "uml.DotEdge",
        "uml.DotNode");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.setStyle(
        new OrthogonalDotUmlClassDiagramStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER,
                new DefaultDotUmlClassDiagramStyle())));
    generator.generate(classes, "DotGraph-CompositePattern");
  }

  @Test
  public void testDotUmlClassDiagramStyleDecoratorPattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.DotUmlClassDiagramStyle",
        "uml.DefaultDotUmlClassDiagramStyle",
        "uml.DotUmlClassDiagramStyleDecorator",
        "uml.ColoredDotUmlClassDiagramStyle",
        "uml.OrthogonalDotUmlClassDiagramStyle");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.setStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER,
                new DefaultDotUmlClassDiagramStyle()));
    generator.generate(classes, "DotUmlClassDiagramStyle-DecoratorPattern");
  }
  
  @Test
  public void testDotUmlClassDiagramGeneratorFacadePattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.UmlClassDiagramConverter",
        "uml.DotUmlClassDiagramConverter",
        "uml.UmlClassDiagramGenerator",
        "uml.UmlMatcher",
        "uml.DotUmlClassDiagramStyle",
        "uml.GraphViz",
        "uml.GraphViewer",
        "uml.JavaClasses",
        "uml.UmlClassDiagramBuilder",
        "uml.CanonicalUmlClassDiagramBuilder");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.setStyle(new ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette.YELLOW_HEADER));
    generator.generate(classes, "DotUmlClassDiagramGenerator-FacadePattern");
  }
 
  @Test
  public void testUmlMatcherInterpreterPattern() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.UmlMatcher",
        "uml.AllUmlMatcher",
        "uml.UmlAnnotationFilter",
        "uml.UmlFieldFilter",
        "uml.UmlFieldTypeFilter",
        "uml.UmlMethodFilter",
        "uml.UmlMethodParameterTypesFilter",
        "uml.UmlMethodReturnTypeFilter",
        "uml.UmlPackageMatcher",
        "uml.UmlPublicMatcher",
        "uml.AndUmlMatcher",
        "uml.UmlMethodTypesFilter",
        "uml.NotUmlMatcher",
        "uml.OrUmlMatcher");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new UmlMethodTypesFilter()));
    generator.setStyle(new ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette.YELLOW_HEADER));
    generator.generate(classes, "UmlMatcher-InterpreterPattern");
  }

  @Test
  public void testUmlAll() throws IOException {
    List<String> classes = Arrays.asList(
        "uml.AllUmlMatcher", 
        "uml.AndUmlMatcher", 
        "uml.CanonicalUmlClassDiagramBuilder", 
        "uml.CanonicalUmlClassDiagramConverter", 
        "uml.ColoredDotUmlClassDiagramStyle", 
        "uml.DefaultDotUmlClassDiagramStyle", 
        "uml.DotEdge", 
        "uml.DotElement", 
        "uml.DotGraph", 
        "uml.DotNode", 
        "uml.DotSection", 
        "uml.DotUmlClassDiagramConverter", 
        "uml.DotUmlClassDiagramStyle", 
        "uml.DotUmlClassDiagramStyleDecorator", 
        "uml.GenericUmlVisitor", 
        "uml.GraphViewer", 
        "uml.GraphViz", 
        "uml.HtmlTable", 
        "uml.HtmlTableCell", 
        "uml.JavaClassesConverter", 
        "uml.MutableUmlAbstractClass", 
        "uml.MutableUmlAnnotation", 
        "uml.MutableUmlClass", 
        "uml.MutableUmlConcreteClass", 
        "uml.MutableUmlEntity", 
        "uml.MutableUmlField", 
        "uml.MutableUmlInterface", 
        "uml.MutableUmlMethod", 
        "uml.NotUmlMatcher", 
        "uml.OrUmlMatcher", 
        "uml.OrthogonalDotUmlClassDiagramStyle", 
        "uml.UmlAbstractClass", 
        "uml.UmlAnnotation", 
        "uml.UmlAnnotationFilter", 
        "uml.UmlArray", 
        "uml.UmlClass", 
        "uml.UmlClassDiagramBuilder", 
        "uml.UmlClassDiagramConverter", 
        "uml.UmlClassDiagramConverterAdapter", 
        "uml.UmlClassDiagramGenerator", 
        "uml.UmlClassDiagramPalette", 
        "uml.UmlClassMatcher", 
        "uml.UmlConcreteClass", 
        "uml.UmlDiagramGeneratorFrame", 
        "uml.UmlDiagramGeneratorGui", 
        "uml.UmlDiagramGeneratorPanel", 
        "uml.UmlEntity", 
        "uml.UmlEnum", 
        "uml.UmlField", 
        "uml.UmlFieldFilter", 
        "uml.UmlFieldTypeFilter", 
        "uml.UmlGenerator", 
        "uml.UmlInterface", 
        "uml.UmlMatcher", 
        "uml.UmlMethod", 
        "uml.UmlMethodFilter", 
        "uml.UmlMethodParameterTypesFilter", 
        "uml.UmlMethodReturnTypeFilter", 
        "uml.UmlMethodTypesFilter", 
        "uml.UmlPackageMatcher", 
        "uml.UmlPrimitiveType", 
        "uml.UmlPublicMatcher", 
        "uml.UmlVisitor", 
        "uml.UmlVisitorAdapter");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setUmlMatcher(
            new AndUmlMatcher(
                new UmlClassMatcher(classes),
                new AndUmlMatcher(
                    new UmlMethodTypesFilter(),
                    new UmlAnnotationFilter())));
    generator.setStyle(new ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette.YELLOW_HEADER));
    generator.generate(classes, "UmlAll");
  }
 
  @Test
  public void testBuilderPattern() throws IOException {
    List<String> classes = Arrays.asList("patterns.builder.Director");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setStyle(
        new OrthogonalDotUmlClassDiagramStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER)));
    generator.generate(classes, "patterns-BuilderPattern");
  }
 
  @Test
  public void testCompositePattern() throws IOException {
    List<String> classes = Arrays.asList("patterns.composite.Client");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setStyle(
        new OrthogonalDotUmlClassDiagramStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER)));
    generator.generate(classes, "patterns-CompositePattern");
  }

  @Test
  public void testDecoratorPattern() throws IOException {
    List<String> classes = Arrays.asList("patterns.decorator.Client");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setStyle(
        new ColoredDotUmlClassDiagramStyle(
            UmlClassDiagramPalette.YELLOW_HEADER));
    generator.generate(classes, "patterns-DecoratorPattern");
  }
 
  @Test
  public void testObserverPattern() throws IOException {
    List<String> classes = Arrays.asList("patterns.observer.ConcreteObserver");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setStyle(
        new OrthogonalDotUmlClassDiagramStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER)));
    generator.generate(classes, "patterns-ObserverPattern");
  }
 
  @Test
  public void testStatePattern() throws IOException {
    List<String> classes = Arrays.asList("patterns.state.Client");
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setOutputFormat("png");
    generator.setStyle(
        new OrthogonalDotUmlClassDiagramStyle(
            new ColoredDotUmlClassDiagramStyle(
                UmlClassDiagramPalette.YELLOW_HEADER)));
    generator.generate(classes, "patterns-StatePattern");
  }
  
  CanonicalUmlClassDiagramBuilder builder;
  JavaClassesConverter javaClassesConverter;
}
