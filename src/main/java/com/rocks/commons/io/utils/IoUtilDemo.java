package com.rocks.commons.io.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * IOUtils示例
 * @author lizhaoxuan
 */
@Slf4j
public class IoUtilDemo {

    @SneakyThrows
    public static void main(String[] args)  {
        String encoding = "UTF-8";
        File sourceFile = new File("D:\\system\\target\\demo2.txt");
        FileInputStream sourceFileInputStream = new FileInputStream(sourceFile);
        File targetFile = new File("D:\\system\\target\\demo3.txt");
        FileOutputStream targetFileOutputStream = new FileOutputStream(targetFile);

        // 由于toString读取一次 导致toByteArray会读取不到数据
        // 从文本文件中读出内容
        String content = IOUtils.toString(sourceFileInputStream, encoding);
        byte[] bytes = IOUtils.toByteArray(sourceFileInputStream);
        System.out.println(content);
        System.out.println(new String(bytes,encoding));
        // 从文本文件中分行读取内容
        List<String> lines = IOUtils.readLines(sourceFileInputStream, encoding);
        System.out.println(lines);

        // 文件拷贝
        IOUtils.copy(sourceFileInputStream,targetFileOutputStream);
        // 大文件拷贝  例如2G以上等  会将缓冲区设置大
        IOUtils.copyLarge(sourceFileInputStream,targetFileOutputStream);

        // 从字符串获取输入流 可指定编码
        InputStream inputStream = IOUtils.toInputStream("File Content", encoding);
        // 获取带缓冲区的输入流 默认缓冲区1024
        InputStream bufferedInputStream = IOUtils.toBufferedInputStream(inputStream, 2048);

        // 从流中读取数据到缓冲区
        byte[] buffer = new byte[1024];
        IOUtils.read(inputStream, buffer);
        // 将缓冲区数据写入流中
        IOUtils.write("Hello",targetFileOutputStream,encoding);

        // 两个流的内容比较
        boolean b = IOUtils.contentEquals(sourceFileInputStream, inputStream);
        // 忽略换行符
        boolean b2= IOUtils.contentEqualsIgnoreEOL(new InputStreamReader(sourceFileInputStream), new InputStreamReader(inputStream));

        // 让流跳过指定长度
        IOUtils.skip(sourceFileInputStream,8);
    }

}
