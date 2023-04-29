package mzm.event;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Singleton
{
  String value();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\Singleton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */