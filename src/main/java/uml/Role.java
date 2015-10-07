package uml;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Roles.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
  String role();
}
