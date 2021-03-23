package com.rocks.commons.lang3;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * StringUtils示例代码
 * @author lizhaoxuan
 */
public class StringUtilsDemo {

    public static void main(String[] args) {

        // 判断字符串是否为 null 空串 空白字符
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isNotBlank(" "));

        // 判断字符串是否为 null 空串
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isNotEmpty(" "));

        // 判断字符串是否是数字 不忽略空格
        System.out.println(StringUtils.isNumeric(" 23"));
        // 判断字符串是否是数字 忽略空格
        System.out.println(StringUtils.isNumericSpace(" 23 "));

        // 判断字符串是否是希腊字母 不忽略空格
        System.out.println(StringUtils.isAlpha("asd"));
        System.out.println(StringUtils.isAlpha(" asd"));
        System.out.println(StringUtils.isAlpha("dsadw-cev"));
        System.out.println(StringUtils.isAlpha("dwdasd9eve"));
        // 判断字符串是否是希腊字母 忽略空格
        System.out.println(StringUtils.isAlphaSpace(" asd "));

        // 判断是否全部小写字母
        System.out.println(StringUtils.isAllLowerCase("dasdcsdd"));
        System.out.println(StringUtils.isAllLowerCase("cwdveW"));
        System.out.println(StringUtils.isAllLowerCase("dsadcd83"));
        System.out.println(StringUtils.isAllLowerCase("dasdacf;"));

        // 判断是否全部大写
        System.out.println(StringUtils.isAllUpperCase("WDASCASDA09"));
        System.out.println(StringUtils.isAllUpperCase("DQDWEDVWE;"));
        System.out.println(StringUtils.isAllUpperCase("DEAFAFASD DSAD"));

        // 判断字符串是否包含 区分大小写
        System.out.println(StringUtils.contains("demo1demo2","demo2"));
        System.out.println(StringUtils.contains("demo1","m"));
        System.out.println(StringUtils.contains("deMo1","m"));
        // 判断字符串是否包含 不区分大小写
        System.out.println(StringUtils.containsIgnoreCase("deMo1","m"));
        // 判断字符串是否包含可变参数中任意一个
        System.out.println(StringUtils.containsAny("demo1demo2demo3","demo","demo2"));



        // 去掉字符串前后空格
        String trim = StringUtils.trim(" dsadas");
        String trim1 = StringUtils.trim(null);
        System.out.println(trim + ":" + trim1);

        // 判断字符串是否相等
        StringUtils.equals("demo","Demo");
        StringUtils.equalsIgnoreCase("demo","Demo");
        StringUtils.equalsAny("demo3","demo1","demo2","demo3");
        StringUtils.equalsAny("demo3","Demo3","demo2");

        // 从指定位置开始查找子串
        StringUtils.indexOf("This is a string","is",0);
        StringUtils.indexOfIgnoreCase("This is a String","Is",0);
        StringUtils.indexOfAny("This is a String","Is","a","string","h");

        // 大小写转换
        String demo = StringUtils.upperCase("demo");
        String demo1 = StringUtils.lowerCase("Demo");
        System.out.println(demo + ":" + demo1);

        // 首字母转大写
        String spark = StringUtils.capitalize("spark");
        System.out.println(spark);

        // 将字符串前后用空格填充 使其长度达到size 如果str长度本身大于size 不做填充
        String demo2 = StringUtils.center("demo", 10);
        String demo3 = StringUtils.center("demo", 3);
        System.out.println(demo2 + ":" + demo3);

        // 字符串比较
        StringUtils.compare("demo1","Demo2");
        StringUtils.compareIgnoreCase("demo1","Demo2");

        // 查找某个字符串出现的次数
        int i = StringUtils.countMatches("This is a String", "is");
        int i1 = StringUtils.countMatches("This is a String", "i");
        System.out.println(i + ":" + i1);

        // 将列表里的所有字符串用分隔符拼接 默认分隔符为null
        String join = StringUtils.join("demo1", "demo2", "demo3");
        String join1 = StringUtils.join(Arrays.asList("demo1", "demo2", "demo3"), ",");
        System.out.println(join + " : " + join1);

        // 当字符串为null或空串或空格时返回默认值
        String aDefault = StringUtils.defaultIfBlank(null, "default");
        String s = StringUtils.defaultIfBlank(" ", "default");
        System.out.println(aDefault + ":" + s);
        // 为null或空串时返回默认值
        String aDefault1 = StringUtils.defaultIfEmpty("", "default");
        String s1 = StringUtils.defaultIfEmpty(" ", "default");
        System.out.println(aDefault1 + ":" + s1);
        // 为null时返回默认值
        String s2 = StringUtils.defaultString("dem", "default");
        System.out.println(s2);

    }

}
