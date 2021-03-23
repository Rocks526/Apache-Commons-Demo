package com.rocks.commons.lang3;

import com.rocks.commons.lang3.vo.Product;
import com.rocks.commons.lang3.vo.User;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;


/**
 * ObjectUtils代码示例
 * @author lizhaoxuan
 */
public class ObjectUtilsDemo {

    public static void main(String[] args) {

        // 检查可变参数的所有元素是否都不为null
        System.out.println(ObjectUtils.allNotNull("demo",1,new Object()));
        // 检查可变参数的所有元素是否有不是null的值
        System.out.println(ObjectUtils.anyNotNull("demo",null));

        // 对象克隆 必须继承Cloneable接口 重写clone方法
        User user = new User().setId(1L).setUsername("Rocks").setPassword("123456")
                .setAge(22).setMoney(new BigDecimal(20.0)).setCreateTime(new Date())
                .setProduct(new Product().setName("product1").setDesc("this is a product"))
                .setExtendInfos(Arrays.asList("extends1","extends2"));
        User clone = ObjectUtils.clone(user);
        System.out.println(clone);
        // 对象克隆 先调clone 如果返回为null  则返回原对象
        System.out.println(ObjectUtils.cloneIfPossible(user));

        // 比较  如果 c1 < c2,则返回负数；如果 c1 > c2,则返回正数；如果 c1 = c2,则返回 0
        System.out.println(ObjectUtils.compare("Test","test"));
        // 第三个参数为 元素为null时代表最大还是最小
        System.out.println(ObjectUtils.compare("Test",null,true));

        // 如果对象为null 返回默认值
        System.out.println(ObjectUtils.defaultIfNull(null,""));

        // 返回数组中不是null的第一个值
        System.out.println(ObjectUtils.firstNonNull(null,"","demo"));

        // 检查对象是否为空 支持：CharSequence、Array、Collection、Map
        System.out.println(ObjectUtils.isEmpty(""));
        System.out.println(ObjectUtils.isEmpty(" "));
        System.out.println(ObjectUtils.isEmpty(new Object()));
        System.out.println(ObjectUtils.isEmpty(new HashMap<>()));
        // 检查对象是否不为空
        System.out.println(ObjectUtils.isNotEmpty(Arrays.asList(null,"")));

        // 获取最大 最小 中位数
        System.out.println(ObjectUtils.max(1,2,-3));
        System.out.println(ObjectUtils.min(-1,2,3));
        System.out.println(ObjectUtils.median(1,-2,3));
        System.out.println(ObjectUtils.median(1,-2,3,0));

    }

}
