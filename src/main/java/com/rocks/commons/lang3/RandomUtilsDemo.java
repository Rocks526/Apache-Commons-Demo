package com.rocks.commons.lang3;

import org.apache.commons.lang3.RandomUtils;

/**
 * RandomUtils示例代码
 * @author lizhaoxuan
 */
public class RandomUtilsDemo {

    public static void main(String[] args) {

        // 生成 0-Integer.MAX_VALUE 的随机int
        System.out.println(RandomUtils.nextInt());
        // 生成指定范围的随机int  左闭右开
        System.out.println(RandomUtils.nextInt(0,10));

        // 生成随机Boolean
        System.out.println(RandomUtils.nextBoolean());

        // 生成 0-Long.MAX_VALUE 的随机long
        System.out.println(RandomUtils.nextLong());
        // 生成指定范围的随机long 左闭右开
        System.out.println(RandomUtils.nextLong(0,100));

        // 生成指定个数的字节数组
        System.out.println(RandomUtils.nextBytes(10));

        // 生成随机Double
        System.out.println(RandomUtils.nextDouble());
        System.out.println(RandomUtils.nextDouble(0,100.0));

        // 生成随机float
        System.out.println(RandomUtils.nextFloat());
        System.out.println(RandomUtils.nextFloat(0,100.0f));

    }

}
