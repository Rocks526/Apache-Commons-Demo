package com.rocks.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ArrayUtils代码示例
 * @author lizhaoxuan
 */
public class ArrayUtilsDemo {

    public static void main(String[] args) {

        // 创建数组
        System.out.println(ArrayUtils.toArray("demo1","demo2","demo3"));

        // 判断两个数组是否相等
        String[] arr1 = ArrayUtils.toArray("demo1","demo2","demo3");
        String[] arr2 = ArrayUtils.toArray("demo1","demo2","demo3",null);
        // arr2多一个null元素 不相等 没有null相等
        System.out.println(ArrayUtils.isEquals(arr1,arr2));

        // 判断是否是空数组
        String[] arr3 = new String[]{};
        System.out.println(ArrayUtils.isEmpty(arr3));

        // 判断数组是否包含某个元素
        System.out.println(ArrayUtils.contains(arr1,"demo2"));

        // 二维数组转换map
        String[][] arr4 = new String[][]{
                { "RED", "#FF0000" },
                { "GREEN", "#00FF00" },
                { "BLUE", "#0000FF" }
        };
        System.out.println(ArrayUtils.toMap(arr4));
    }

}
