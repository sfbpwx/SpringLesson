package thinking.in.spring.ioc.overview.dependency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//
@Retention(RetentionPolicy.RUNTIME)//运行时
public @interface Super {
}
