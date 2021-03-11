package com.rocks.commons.io.comparator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 比较器示例代码
 * @author lizhaoxuan
 */
public class ComparatorDemo {

    private static final String dirPath = "D:\\system\\target";

    public static void main(String[] args) {

        Collection<File> filesTmp = FileUtils.listFiles(new File(dirPath), null, false);
        List<File> files = filesTmp.stream().collect(Collectors.toList());

        // 按文件名称排序 设置大小写不敏感
        NameFileComparator nameFileComparator = new NameFileComparator(IOCase.INSENSITIVE);
        List<File> sort = nameFileComparator.sort(files);
        System.out.println(sort);

        // 按照文件大小排序
        SizeFileComparator sizeFileComparator = new SizeFileComparator();
        List<File> sort1 = sizeFileComparator.sort(files);
        System.out.println(sort1);

        // 按最后修改时间排序
        LastModifiedFileComparator lastModifiedFileComparator = new LastModifiedFileComparator();
        List<File> sort2 = lastModifiedFileComparator.sort(files);
        System.out.println(sort2);

    }

}
