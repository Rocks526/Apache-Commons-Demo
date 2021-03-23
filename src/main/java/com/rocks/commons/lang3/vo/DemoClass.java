package com.rocks.commons.lang3.vo;


/**
 * 测试实体
 * @author lizhaoxuan
 */
public class DemoClass implements DemoClassSuper {

    @MyAnnotation
    public static void demo1(){
        System.out.println("demo1");
    }

    @MyAnnotation
    public void demo2(){
        System.out.println("demo2");
    }

    @MyAnnotation
    private void demo3(){
        System.out.println("demo3");
    }


}
