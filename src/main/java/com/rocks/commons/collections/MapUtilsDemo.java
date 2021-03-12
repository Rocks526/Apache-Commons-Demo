package com.rocks.commons.collections;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;

/**
 * MapUtils代码示例
 * @author lizhaoxuan
 */
public class MapUtilsDemo {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("demo","true");
        hashMap.put("demo2","value2");
        hashMap.put("demo3",true);
        hashMap.put("demo4",12);
        hashMap.put("demo5",12.3f);

        // 判断Map是否为空
        System.out.println(MapUtils.isEmpty(hashMap));
        System.out.println(MapUtils.isNotEmpty(hashMap));

        // 从Map获取指定类型值 支持默认值
        System.out.println(MapUtils.getBoolean(hashMap,"demo1",false));
        System.out.println(MapUtils.getBoolean(hashMap,"demo3",false));
        System.out.println(MapUtils.getFloat(hashMap,"demo5",0f));
        System.out.println(MapUtils.getString(hashMap,"demo2",""));
        System.out.println(MapUtils.getInteger(hashMap,"demo2",0));
    }

}
