package com.rocks.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * NumberUtils示例代码
 * @author lizhaoxuan
 */
public class NumberUtilsDemo {

    public static void main(String[] args) {

        // 内置常量 包含各个包装类型的0 1 -1 其他类似的不再演示
        System.out.println(NumberUtils.LONG_ZERO);
        System.out.println(NumberUtils.LONG_ONE);
        System.out.println(NumberUtils.LONG_MINUS_ONE);

        // 比较
        System.out.println(NumberUtils.compare(0,9));
        System.out.println(NumberUtils.compare(9L,1119L));

        // 将字符串转成 BigInteger/BigDecimal/Double等，支持 10进制，十六进制（以0X或者#开头）、8进制（以0开头）
        // 如果 str 为 null，则返回 null。如果转换错误，则抛出 NumberFormatException
        System.out.println(NumberUtils.createBigInteger("986722"));
        System.out.println(NumberUtils.createBigDecimal("321312.343"));
        System.out.println(NumberUtils.createDouble("2321.44"));

        // 判断字符串是否是有效数字 支持16进制、8进制、10进制、正数负数、科学计数法
        System.out.println(NumberUtils.isCreatable("8.788006e+05"));

        // 最大值 最小值
        System.out.println(NumberUtils.max(1,2,3,5));
        System.out.println(NumberUtils.min(0.4f,3,89L));

        // 字符串转Long Double等 支持默认值
        System.out.println(NumberUtils.toInt("2",0));
        System.out.println(NumberUtils.toLong("2321",0L));

    }

}
