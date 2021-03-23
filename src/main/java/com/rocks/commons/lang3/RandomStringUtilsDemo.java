package com.rocks.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * RandomStringUtils代码示例
 * @author lizhaoxuan
 */
public class RandomStringUtilsDemo {

    public static void main(String[] args) {

        // 创建长度为指定个数的随机字符串 将从所有字符集中选择字符 不含字母和数字
        System.out.println(RandomStringUtils.random(10));
        // 创建长度为指定个数的随机字符串 将从字母或数字里选择
        // 第二个参数是代表是否选择字母 第三个参数代表是否选择数字 如果都为false 则等同于random(10)
        System.out.println(RandomStringUtils.random(10,true,true));
        // 创建长度为指定个数的随机字符串 字符从后面的可变参数中选取
        System.out.println(RandomStringUtils.random(10,'a','b','c'));
        // 创建长度为指定个数的随机字符串 字符从后面的字符串中选取
        System.out.println(RandomStringUtils.random(10,"spark flink"));

        // 创建指定长度的随机字符串 字符从(a-zA-Z)里选择 等同于random(10,true,false)
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        // 创建指定长度范围的随机字符串 字符从(a-zA-Z)里选择
        System.out.println(RandomStringUtils.randomAlphabetic(3,10));

        // 创建指定长度的随机字符串 字符从字母和数字里选择 等同于random(10,true,true)
        System.out.println(RandomStringUtils.randomAlphanumeric(10));
        // 创建指定长度范围的随机字符串 字符从字母和数字里选择
        System.out.println(RandomStringUtils.randomAlphanumeric(3,10));

        // 随机字符将从 ASCII 码值介于 [32,126] 之间的字符集中选择，等价于：random(count, 32, 127, false, false)
        System.out.println(RandomStringUtils.randomAscii(10));
        System.out.println(RandomStringUtils.randomAscii(3,10));

        // 随机字符从所有可见的 ASCII 字符中选择，即除空格和控制字符外的任何内容，等价于：random(count, 33, 126, false, false)
        System.out.println(RandomStringUtils.randomGraph(10));
        System.out.println(RandomStringUtils.randomGraph(3,10));

        // 创建长度为指定字符数的随机字符串，随机字符将从数字字符集中选择。
        System.out.println(RandomStringUtils.randomNumeric(10));
        System.out.println(RandomStringUtils.randomNumeric(3,10));

    }

}
