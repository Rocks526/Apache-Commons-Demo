package com.rocks.commons.io.filter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;

/**
 *  过滤器代码示例
 * @author lizhaoxuan
 */
public class FilterDemo {

    private static final String dirPath = "D:\\system";

    private static final String[] acceptFileNames = {"README.md","demo.txt"};

    private static final String[] suffixFileNames = {"md","txt","vue"};

    public static void main(String[] args) {

        dirList();
        FileUtilsList();
    }

    /**
     * 使用FileUtils的递归遍历目录下所有文件
     * 由于FileUtils没提供支持过滤器和递归遍历的api 因此只能先根据后缀匹配 拿到所有文件 然后steam过滤
     */
    private static void FileUtilsList(){

        Collection<File> files = FileUtils.listFiles(new File(dirPath), null, true);

        // 文件名过滤器  所有过滤器都允许传入多个匹配参数 后续只以一个示例
        files.stream().filter(new NameFileFilter(acceptFileNames)::accept).forEach(System.out::println);
        System.out.println("==============================================");

        // 通配符过滤器
        files.stream().filter(new WildcardFileFilter("*demo*")::accept).forEach(System.out::println);
        System.out.println("==============================================");

        // 前缀过滤器
        files.stream().filter(new PrefixFileFilter("README")::accept).forEach(System.out::println);
        System.out.println("==============================================");

        // 后缀过滤器
        files.stream().filter(new SuffixFileFilter(suffixFileNames)::accept).forEach(System.out::println);
        System.out.println("==============================================");

        // 逻辑或过滤器
        files.stream().filter(new OrFileFilter(new NameFileFilter(acceptFileNames),new SuffixFileFilter(suffixFileNames))::accept).forEach(System.out::println);
        System.out.println("==============================================");

        // 逻辑与过滤器
        files.stream().filter(new AndFileFilter(new NameFileFilter(acceptFileNames),new SuffixFileFilter(suffixFileNames))::accept).forEach(System.out::println);
        System.out.println("==============================================");
    }

    /**
     * 使用File.list遍历 只能遍历一层目录 不可递归
     */
    private static void dirList(){
        File dir = new File(dirPath);

        // 文件名过滤器  所有过滤器都允许传入多个匹配参数 后续只以一个示例
        String[] list = dir.list(new NameFileFilter(acceptFileNames));
        Arrays.stream(list).forEach(System.out::println);

        // 通配符过滤器
        String[] list1 = dir.list(new WildcardFileFilter("*demo*"));
        Arrays.stream(list1).forEach(System.out::println);

        // 前缀过滤器
        String[] list2 = dir.list(new PrefixFileFilter("REAMDE"));
        Arrays.stream(list2).forEach(System.out::println);

        // 后缀过滤器
        String[] list3 = dir.list(new SuffixFileFilter(suffixFileNames));
        Arrays.stream(list3).forEach(System.out::println);

        // 逻辑或过滤器
        String[] list4 = dir.list(new OrFileFilter(new NameFileFilter(acceptFileNames),new SuffixFileFilter(suffixFileNames)));
        Arrays.stream(list4).forEach(System.out::println);

        // 逻辑与过滤器
        String[] list5 = dir.list(new AndFileFilter(new NameFileFilter(acceptFileNames),new SuffixFileFilter(suffixFileNames)));
        Arrays.stream(list5).forEach(System.out::println);
    }

}
