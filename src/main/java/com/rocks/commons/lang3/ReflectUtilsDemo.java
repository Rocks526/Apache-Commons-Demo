package com.rocks.commons.lang3;

import com.rocks.commons.lang3.vo.DemoClass2;
import com.rocks.commons.lang3.vo.MyAnnotation;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 增强反射相关的工具类代码示例
 * @author lizhaoxuan
 */
public class ReflectUtilsDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        // 根据className获取class 可以指定是否进行初始化
        Class<?> aClass = ClassUtils.getClass("java.lang.Integer",false);

        // 判断是否是内部类
        System.out.println(ClassUtils.isInnerClass(aClass));

        // 判断是否是原始类型或基础类型的包装类
        System.out.println(ClassUtils.isPrimitiveOrWrapper(aClass));
        System.out.println(ClassUtils.isPrimitiveOrWrapper(Integer.class));

        // 获取简短Class名称
        System.out.println(ClassUtils.getShortClassName(aClass));

        // 获取包名
        System.out.println(ClassUtils.getPackageName(aClass));

        // 获取该类的所有父类 不包含接口
        System.out.println(ClassUtils.getAllSuperclasses(aClass));

        // 获取该类的所有接口
        System.out.println(ClassUtils.getAllInterfaces(aClass));

        // 将class和className相互转换
        System.out.println(ClassUtils.convertClassesToClassNames(Arrays.asList(Integer.class,Boolean.class)));
        System.out.println(ClassUtils.convertClassNamesToClasses(Arrays.asList("java.lang.Integer","java.lang.Boolean")));

        // 判断是否是相同的class  包装类型和基本类型class一致
        System.out.println(ClassUtils.isAssignable(Integer.class, int.class));

        // 获取该类的继承结构
        Iterable<Class<?>> hierarchy = ClassUtils.hierarchy(Integer.class);
        hierarchy.forEach(System.out::println);

        // ==========  MethodUtils  ==========================

        // 获取带指定注解的方法  必须是运行时注解 编译期注解无法查找 编译完成后就消失了
        // 后面两个参数是 是否搜找父类和父接口 是否忽略权限(如果为false 则不能查到private)  默认查找父类 不查找private
        System.out.println(MethodUtils.getMethodsListWithAnnotation(DemoClass2.class, MyAnnotation.class));
        System.out.println(MethodUtils.getMethodsListWithAnnotation(DemoClass2.class, MyAnnotation.class,true,true));

        // 调用Method
        System.out.println(MethodUtils.invokeMethod(new Object(),"toString",null));

        // 获取可使用的Method 非private 无须暴力反射
        System.out.println(MethodUtils.getAccessibleMethod(Object.class,"toString"));

    }

}
