package com.rocks.commons.lang3.vo;


/**
 * 测试实体
 * @author lizhaoxuan
 */
public class DemoClass2 extends DemoClass{

    @MyAnnotation
    private void demo5(){
        System.out.println("demo5");
    }

    @MyAnnotation
    public void demo6(){
        System.out.println("demo6");
    }

}
