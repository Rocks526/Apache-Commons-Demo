package com.rocks.commons.io.utils;

import org.apache.commons.io.FilenameUtils;

import java.util.Arrays;

/**
 * FilenameUtils示例
 * @author lizhaoxuan
 */
public class FilenameUtilsDemo {

    private static final String fullName = "D:\\system\\target\\demo1.txt";

    public static void main(String[] args) {

        // 合并目录和文件名为全路径
        String filePath = FilenameUtils.concat("D:\\system\\target", "demo1.txt");
        System.out.println(filePath);

        // 获取文件名
        String name = FilenameUtils.getName(filePath);
        System.out.println(name);

        // 获取文件名 去除目录和后缀后的
        String baseName = FilenameUtils.getBaseName(filePath);
        System.out.println(baseName);

        // 获取文件后缀
        String extension = FilenameUtils.getExtension(filePath);
        System.out.println(extension);

        // 获取文件的目录
        String fullPath = FilenameUtils.getFullPath(filePath);
        System.out.println(fullPath);

        // 转换路径分隔符为当前系统的
        String filePathNew = FilenameUtils.separatorsToSystem(filePath);
        System.out.println(filePathNew);

        // 判断文件路径是否相同
        boolean equals = FilenameUtils.equals(filePath, fullName);
        System.out.println(equals);
        // 判断文件路径是否相同 格式化
        boolean b = FilenameUtils.equalsNormalized(filePath, fullPath);
        System.out.println(b);

        // 判断文件扩展名是否在指定的集合里
        boolean extension1 = FilenameUtils.isExtension(filePath, Arrays.asList("zip", "md", "java"));
        System.out.println(extension1);
    }

}
