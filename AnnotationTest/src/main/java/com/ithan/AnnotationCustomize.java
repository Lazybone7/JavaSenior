package com.ithan;

@MyAnnotation("hello")
@MyAnnotation("heihei")
public class AnnotationCustomize {
    public static void main(String[] args) {

    }
}


class Generic<@TypeAnnotation T>{
    public void show(@TypeAnnotation int i){

    }

}

