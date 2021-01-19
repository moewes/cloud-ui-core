package net.moewes.cloudui.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ TYPE })
@Retention(RUNTIME)
@Documented
@Inherited
public @interface CloudUiView {
  String value();
  boolean standalone() default true;
}
