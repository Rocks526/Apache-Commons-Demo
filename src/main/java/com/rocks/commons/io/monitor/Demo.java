package com.rocks.commons.io.monitor;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Arrays;

/**
 * 对监控的文件进行操作 测试监控API
 * @author lizhaoxuan
 */
public class Demo {

    private static final String filePath = "D:\\system\\target\\demo.txt";

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File(filePath);
        FileUtils.writeLines(file, Arrays.asList("line1", "line2"),"\n",true);
        FileUtils.touch(new File("D:\\system\\target\\demo2.txt"));
        FileUtils.writeLines(new File("D:\\system\\target\\demo2.txt"),Arrays.asList("line1", "line2"),"\n",true);
    }

}
