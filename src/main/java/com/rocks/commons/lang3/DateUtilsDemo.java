package com.rocks.commons.lang3;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtils代码示例
 * @author lizhaoxuan
 */
public class DateUtilsDemo {

    public static void main(String[] args) throws ParseException {

        // 给Date添加几天 减少则第二个参数为负数
        System.out.println(DateUtils.addDays(new Date(),3));

        // 判断是否是同一天
        System.out.println(DateUtils.isSameDay(new Date(),new Date()));

        // 字符串转换Date 可以输入多个匹配模式
        System.out.println(DateUtils.parseDate("2020-02-09 20:23:32","yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"));

        // 设置为本月的第几天 设置月/年/小时/分钟等同理
        System.out.println(DateUtils.setDays(new Date(),31));
        System.out.println(DateUtils.setHours(new Date(),23));
        System.out.println(DateUtils.setMonths(new Date(),9));
        System.out.println(DateUtils.setYears(new Date(),2022));

        // 计算过去了多久
        // 计算从这个月开始过去了多少天
        System.out.println(DateUtils.getFragmentInDays(new Date(), Calendar.MONDAY));
        // 计算今年开始过去了多少天
        System.out.println(DateUtils.getFragmentInDays(new Date(),Calendar.YEAR));
        // 计算今天开始过去了多少小时
        System.out.println(DateUtils.getFragmentInHours(new Date(),Calendar.DATE));
        // 计算今年开始过去了多少小时
        System.out.println(DateUtils.getFragmentInHours(new Date(),Calendar.YEAR));
        // 计算这天过去了多少分钟
        System.out.println(DateUtils.getFragmentInMinutes(new Date(),Calendar.DATE));

    }

}
