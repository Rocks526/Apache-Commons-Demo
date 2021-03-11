package com.rocks.commons.io.monitor;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import java.io.File;

/**
 * 文件监控示例
 * @author lizhaoxuan
 */
public class MonitorDemo {

    private static final String filePath = "D:\\system\\target";

    public static void main(String[] args) throws Exception {
        // 1.创建文件监听对象  也可以监听目录 第二个参数可以传入过滤器
        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(filePath, null);
        // 2.添加文件监听器
        fileAlterationObserver.addListener(new FileAlterationListener() {
            @Override
            public void onStart(FileAlterationObserver fileAlterationObserver) {
                // 开始新一轮扫描
                // System.out.println("file listener scanning start ...");
            }
            @Override
            public void onDirectoryCreate(File file) {
                System.out.println("dir create : " + file.getAbsolutePath());
            }
            @Override
            public void onDirectoryChange(File file) {
                System.out.println("dir changed : " + file.getAbsolutePath());
            }
            @Override
            public void onDirectoryDelete(File file) {
                System.out.println("dir deleted : " + file.getAbsolutePath());
            }
            @Override
            public void onFileCreate(File file) {
                System.out.println("file created : " + file.getAbsolutePath());
            }
            @Override
            public void onFileChange(File file) {
                System.out.println("file changed : " + file.getAbsolutePath());
            }
            @Override
            public void onFileDelete(File file) {
                System.out.println("file deleted : " + file.getAbsolutePath());
            }
            @Override
            public void onStop(FileAlterationObserver fileAlterationObserver) {
                // 新一轮扫描结束
                // System.out.println("file listener scanning stop ...");
            }
        });
        // 3.创建监视器 第一个参数是监控间隔 5s  第二个参数是要监控的对象 可以传入多个
        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(5000, fileAlterationObserver);
        // 4.开始监控
        fileAlterationMonitor.start();
        System.out.println("waiting event ...");
        // 5.停止监控
        Thread.sleep(1000*60*60);
        System.out.println("waiting event end ...");
        fileAlterationMonitor.stop();
        System.out.println("end ...");
    }

}
