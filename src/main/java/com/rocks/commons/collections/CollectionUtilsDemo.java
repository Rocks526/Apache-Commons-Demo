package com.rocks.commons.collections;

import org.apache.commons.collections4.CollectionUtils;
import java.util.Arrays;
import java.util.List;

/**
 * CollectionUtils代码示例
 * @author lizhaoxuan
 */
public class CollectionUtilsDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("demo", "demo2", "demo3");
        List<String> list2 = Arrays.asList("demo", "demo3", "demo2");
        List<String> list3 = Arrays.asList("demo", "test2", "test3");
        List<String> list4 = Arrays.asList("demo", "test2");

        // 判断集合是否为空
        System.out.println(CollectionUtils.isNotEmpty(list));
        System.out.println(CollectionUtils.isEmpty(list));

        // 判断两个集合值是否相等 不考虑顺序
        System.out.println(CollectionUtils.isEqualCollection(list,list2));

        // 两个集合并集
        System.out.println(CollectionUtils.union(list,list3));

        // 两个集合交集
        System.out.println(CollectionUtils.intersection(list,list3));

        // 两个集合差集
        System.out.println(CollectionUtils.subtract(list,list3));

        // 两个集合交集的补集
        System.out.println(CollectionUtils.disjunction(list,list3));

        // 判断是否包含任意一个相同元素
        System.out.println(CollectionUtils.containsAny(list,list3));
        // 判断是否包含全部元素
        System.out.println(CollectionUtils.containsAll(list,list3));

        // 某元素在集合中出现的次数
        System.out.println(CollectionUtils.cardinality("demo",list));

        // 删除子集合
        System.out.println(CollectionUtils.removeAll(list,list4));

    }

}
