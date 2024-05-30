package org.woozi.pratice.jakarta.persistence.entity.annotation;

import org.woozi.pratice.jakarta.persistence.entity.GenerationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratedValue {
     GenerationType strategy() default GenerationType.AUTO;
}
