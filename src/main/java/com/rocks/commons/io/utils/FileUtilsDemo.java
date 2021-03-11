package com.rocks.commons.io.utils;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * FileUtils示例
 * @author lizhaoxuan
 */
public class FileUtilsDemo {

    private static final String ZIP_PREFIX = ".zip";

    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws IOException {

        // 复制文件夹(文件夹里的文件一块复制) 第三个参数可以用来过滤文件 可选
        FileUtils.copyDirectory(new File("D:\\system\\target"), new File("D:\\system\\target2"), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // 过滤掉文件夹里的zip文件
                if (pathname.getName().endsWith(ZIP_PREFIX)){
                    return false;
                }
                return true;
            }
        });
        // 以目录的形式将文件夹复制到另一个文件夹里 作为一个子目录
        FileUtils.copyDirectoryToDirectory(new File("D:\\system\\target"), new File("D:\\system\\target2"));

        // 复制文件
        FileUtils.copyFile(new File("D:\\system\\target\\demo2.txt"), new File("D:\\system\\target\\demo2_bak.txt"));
        // 将文件复制到输出流(可以当做上传/下载等)
        FileUtils.copyFile(new File("D:\\system\\target\\demo2.txt"), new FileOutputStream(new File("D:\\system\\target\\demo2_bak2.txt")));
        // 将文件拷贝到指定目录
        FileUtils.copyFileToDirectory(new File("D:\\system\\target\\demo2.txt"),new File("D:\\system"));
        // 将输入流的内容拷贝到指定文件
        FileUtils.copyInputStreamToFile(new FileInputStream("D:\\system\\target\\demo2.txt"),new File("D:\\system\\target\\demo2_bak3.txt"));
        // 将URL的内容拷贝到指定文件(可以当做下载)
        FileUtils.copyURLToFile(new URL("http://rocks526.top/lzx/image-20200907173628246.png"),new File("D:\\system\\target\\download.png"));

        // 字符串写入文件 设置编码并且设置追加还是覆盖
        FileUtils.writeStringToFile(new File("D:\\system\\target\\demo2.txt"),"\nWrite By FileUtils!",ENCODING,true);
        // 写入字节数组  没有设置append则默认会覆盖原文件
        FileUtils.writeByteArrayToFile(new File("D:\\system\\target\\demo2.txt"),"\nWrite By FileUtils2!".getBytes(StandardCharsets.UTF_8));
        // 将集合内容写入文件 设置每个元素的结尾为 \n 追加模式
        FileUtils.writeLines(new File("D:\\system\\target\\demo2.txt"), Arrays.asList("line1", "line2", "line3"),"\n",true);

        // 移动文件
        FileUtils.moveFile(new File("D:\\system\\target\\demo2.txt"),new File("D:\\system\\demo2.txt"));
        // 移动文件夹
        FileUtils.moveDirectory(new File("D:\\system\\target"),new File("D:\\system\\target2"));
        // 移动文件到文件夹  第三个参数代表文件夹不存在是否创建
        FileUtils.moveFileToDirectory(new File("D:\\system\\demo2.txt"),new File("D:\\system\\target3"),true);
        // 移动文件或目录到指定的文件夹里
        FileUtils.moveToDirectory(new File("D:\\system\\target2"),new File("D:\\system\\target3"),false);

        // 删除文件夹  包括里面的所有文件
        FileUtils.deleteDirectory(new File("D:\\system\\target3"));
        // 清空文件夹里的所有内容
        FileUtils.cleanDirectory(new File("D:\\system\\target2"));

        // 递归创建文件夹
        FileUtils.forceMkdir(new File("D:\\system\\target3\\target3\\demo"));

        // 测试文件修改时间
        Date date = new Date();
        boolean fileNewer = FileUtils.isFileNewer(new File("D:\\system\\target"), date);
        System.out.println(fileNewer);
        FileUtils.writeLines(new File("D:\\system\\target\\demo.txt"),Arrays.asList("first line ", "second line"),"\n",true);
        boolean fileNewer2 = FileUtils.isFileNewer(new File("D:\\system\\target"), date);
        System.out.println(fileNewer2);
        // 对比两个文件修改时间
        boolean fileNewer1 = FileUtils.isFileNewer(new File("D:\\system\\target\\demo.txt"), new File("D:\\system\\target"));
        System.out.println(fileNewer1);

        // 遍历文件或文件夹  第三个参数是是否递归遍历子文件夹  第二个参数是限制后缀
        Collection<File> files = FileUtils.listFiles(new File("D:\\system"), new String[]{"txt", "zip", "md"}, true);
        files.stream().forEach(System.out::println);
        // 后面两个参数可以设置文件过滤器和文件夹过滤器 自定义过滤条件
        Collection<File> files1 = FileUtils.listFiles(new File("D:\\system"),null,null);
        System.out.println(files1);

        // 判断文件是否是符号连接
        boolean symlink = FileUtils.isSymlink(new File("D:\\software\\RedisDesktopManager\\Another Redis Desktop Manager.exe"));
        System.out.println(symlink);
        // 判断文件夹内是否包含某个文件或者文件夹
        boolean b = FileUtils.directoryContains(new File("D:\\system"), new File("D:\\system\\target\\demo.txt"));
        System.out.println(b);
        // 获取文件或文件夹的大小
        long size = FileUtils.sizeOf(new File("D:\\system\\lin-cms-vue"));
        System.out.println(size);
        // 创建文件
        FileUtils.touch(new File("D:\\system\\demo.txt"));
        // 比较两个文件内容是否相同
        boolean equals = FileUtils.contentEquals(new File("D:\\system\\demo.txt"), new File("D:\\system\\demo2.txt"));
        System.out.println(equals);
    }

}
