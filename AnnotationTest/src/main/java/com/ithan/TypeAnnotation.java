package com.ithan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE,ElementType.TYPE_USE})
public @interface TypeAnnotation {
    String value() default "111";
}
