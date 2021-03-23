package com.rocks.commons.beanutils;

import com.rocks.commons.beanutils.vo.Product;
import com.rocks.commons.beanutils.vo.User;
import com.rocks.commons.beanutils.vo.UserVo;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * BeanUtils工具包示例代码 (不建议使用 推荐使用Spring的BeanUtils)
 * @author lizhaoxuan
 */
public class Demo {

    public static void main(String[] args) {

        User user = new User()
                .setId(1L)
                .setUsername("Rocks")
                .setPassword("123456")
                .setAge(22)
                .setCreateTime(new Date())
                .setMoney(new BigDecimal("39999.0"))
                .setProduct(new Product().setName("car").setDesc("a beautiful car"))
                .setExtendInfos(Arrays.asList("extend1","extend2"));

        convertUtilsDemo(user);
        beanUtilsDemo(user);
    }

    @SneakyThrows
    private static void beanUtilsDemo(User user) {

        // 属性复制  ==>  检查对象类型 是否是DynaBean或者Map  如果不是 则遍历所有属性进行复制 前提是可读可写 由于不可写 复制全部为null
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userVo,user);
        System.out.println(userVo);

        // 获取对象描述
        Map<String, String> describe = BeanUtils.describe(user);
        System.out.println(describe);

        // 将Map转换为对象
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("desc","A person builder");
        stringObjectHashMap.put("notExistProperty","Test");
        BeanUtils.populate(userVo,stringObjectHashMap);
        System.out.println(userVo);

        // 对象克隆 new出新的对象 然后copyProperties
        User cloneUser = (User) BeanUtils.cloneBean(user);
        System.out.println(cloneUser);
        user.getProduct().setName("car2");
        System.out.println(cloneUser.getProduct());
        user.getExtendInfos().add("extend3");
        System.out.println(cloneUser.getExtendInfos());
    }

    private static void convertUtilsDemo(User user) {
        // 对象转字符串
        String userStr = ConvertUtils.convert(user);
        System.out.println(userStr);

        // 注册转换器
        ConvertUtils.register(new Converter() {
            @SneakyThrows
            @Override
            public <T> T convert(Class<T> aClass, Object value) {
                return (T) new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(value.toString());
            }
        },Date.class);

        // 字符串转指定类型对象 (会先去查找class的转换器 如果没有注册则报错)
        Object convertDate = ConvertUtils.convert("2021/02/01 20:30:20", Date.class);
        System.out.println(convertDate);
    }

}
