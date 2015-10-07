package uml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * This class converts a collection of Java classes to UML classes.
 */
@Role(role = "Builder.Director")
public class JavaClassesConverter {
  public JavaClassesConverter(UmlMatcher matcher, UmlClassDiagramBuilder builder) {
    this.matcher = matcher;
    this.builder = builder;
  }

  public void convertClassNames(Collection<String> classNames) {
    Collection<Class<?>> classes = new ArrayList<Class<?>>();
    for (String className : classNames) {
      try {
        classes.add(Class.forName(className));
      } catch (ClassNotFoundException | NoClassDefFoundError e) {
        System.err.println(e.getMessage());
      }
    }

    convertClasses(classes);
  }

  public void convertClasses(Collection<Class<?>> classes) {
    queue.clear();
    visited.clear();

    for (Class<?> c : classes) {
      queue.add(c);
    }

    while (!queue.isEmpty()) {
      Class<?> c = queue.remove();
      if (c.getCanonicalName().equals("java.lang.Object")) {
        continue;  // FIXME
      }
      if (!visited.contains(c)) {
        visited.add(c);
        convertClass(c);
      }
    }
  }

  private void convertClass(Class<?> c) {
    if (!matches(c)) {
      return;
    }
    
    if (c.isInterface()) {
      builder.addInterface(c.getCanonicalName());
    } else if (Modifier.isAbstract(c.getModifiers())) {
      builder.addAbstractClass(c.getCanonicalName());
    } else {
      // TODO: enum, array, annotation, etc.
      builder.addConcreteClass(c.getCanonicalName());
    }
    builder.setModifiers(c.getModifiers());
    
    Class<?> s = c.getSuperclass();
    if (s != null) {
      builder.setSuperclass(s.getCanonicalName());
      queue.add(s);
    }

    for (Class<?> i : c.getInterfaces()) {
      builder.addSuperinterface(i.getCanonicalName());
      queue.add(i);
    }

      for (Field f : c.getDeclaredFields()) {
        if (f.isSynthetic()) {
          continue;
        }
        builder.addField(f.getName(), f.getType().getCanonicalName());
        builder.setModifiers(f.getModifiers());
        if (matches(f.getType()) && matcher.matchesFieldType()) {
          queue.add(f.getType());
        }
      }

    for (Method m : c.getDeclaredMethods()) {
      if (m.isSynthetic() || m.isBridge()) {
        continue;
      }
      builder.addMethod(m.getName());
      builder.setModifiers(m.getModifiers());
      builder.setReturnType(m.getReturnType().getCanonicalName());
     
      if (matches(m.getReturnType()) && matcher.matchesMethodReturnType()) {
        queue.add(m.getReturnType());
      }
      for (Class<?> p : m.getParameterTypes()) {
        builder.addParameter(p.getCanonicalName());
        if (matches(p) && matcher.matchesMethodParameterTypes()) {
          queue.add(p);
        }
      }
    }
  
    for (Annotation a : c.getDeclaredAnnotations()) {
      builder.addAnnotation(a);
    }
  }
  
  private boolean matches(Class<?> c) {
    return !(c.isPrimitive() || c.isArray() || c.isSynthetic());
  }
  
  private UmlMatcher matcher;
  private UmlClassDiagramBuilder builder;
  // TODO: Store String instead of Class<?>?
  private Queue<Class<?>> queue = new LinkedList<Class<?>>();
  private Set<Class<?>> visited = new HashSet<Class<?>>();
}
