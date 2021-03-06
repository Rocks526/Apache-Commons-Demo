package com.rocks.commons.compress;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;

/**
 * Zip文件压缩/解压
 * @author lizhaoxuan
 */
@Slf4j
public class ZipFileDemo {

    public static void main(String[] args) {
        // 压缩文件
        compressZipFile("D:\\system\\target.zip","D:\\system\\demo1.docx","D:\\system\\demo2.txt","D:\\system\\system.zip");
        // 随机解压
        deCompressRandom("D:\\system\\target.zip","D:\\system\\target\\");
        // 顺序解压
        deCompressOrder("D:\\system\\target.zip","D:\\system\\target2\\","system.zip");
    }


    /**
     * 压缩zip文件
     * @param targetFileName 压缩后zip文件的路径
     * @param sourceFileNames  源文件路径
     */
    public static void compressZipFile(String targetFileName,String ...sourceFileNames){
        try {
            if (null == sourceFileNames || sourceFileNames.length == 0){
                throw new RuntimeException("params is empty!");
            }
            // 目标文件
            File file = new File(targetFileName);
            // 创建zip文件输出流
            ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(file);
            // 可以设置压缩等级
            zipArchiveOutputStream.setLevel(5);
            // 可以设置压缩算法，当前支持ZipEntry.DEFLATED和ZipEntry.STORED两种
            zipArchiveOutputStream.setMethod(ZipEntry.DEFLATED);
            FileInputStream fileInputStream;
            byte[] buffer = new byte[4096];
            for (String sourceFileName : sourceFileNames){
                // 构建原文件
                File sourceFile = new File(sourceFileName);
                fileInputStream = new FileInputStream(sourceFile);
                // 构建zip项文件 参数是zip里文件名字
                ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(sourceFile.getName());
                // 也可以为每个文件设置压缩算法
                zipArchiveEntry.setMethod(ZipEntry.DEFLATED);
                // 在zip中添加一个文件
                zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
                // 添加文件内容
                int len = 0;
                while ((len = fileInputStream.read(buffer)) > 0){
                    zipArchiveOutputStream.write(buffer,0,len);
                }
                // 完成一个文件的写入
                zipArchiveOutputStream.closeArchiveEntry();
            }
            zipArchiveOutputStream.close();
            log.info("success");
        }catch (Exception e){
            log.error("compress zip file error,reason:{}",e.getMessage());
        }
    }

    /**
     * 解压zip文件 : 随机访问
     * @param zipFilePath  zip包路径
     * @param deCompressPath    解压目标路径
     * @param files 要解压出来的文件名   如果为null则解压全部文件
     */
    public static void deCompressRandom(String zipFilePath,String deCompressPath,String...files){
        try {
            // 参数解析
            Boolean isAll = Boolean.FALSE;
            if (null == files || files.length == 0){
                isAll = Boolean.TRUE;
            }
            // 构造zip文件
            ZipFile zipFile = new ZipFile(zipFilePath);
            byte[] buffer = new byte[4096];
            InputStream inputStream;
            ZipArchiveEntry entry;
            FileOutputStream fileOutputStream;
            // 解压目标文件
            if (!isAll){
                for (String file : files){
                    // 获取指定文件
                    entry = zipFile.getEntry(file);
                    inputStream = zipFile.getInputStream(entry);
                    File deCompressFile = new File(deCompressPath.concat(file));
                    if (!deCompressFile.getParentFile().exists()){
                        deCompressFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(deCompressFile);
                    int len = 0;
                    while ((len = inputStream.read(buffer)) > 0){
                        fileOutputStream.write(buffer,0,len);
                    }
                    inputStream.close();
                    fileOutputStream.close();
                }
                log.info("success!");
                return;
            }
            // 解压全部文件
            Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
            while (entries.hasMoreElements()) {
                // 获取下一个文件
                entry = entries.nextElement();
                if (entry.isDirectory()) {
                    continue;
                }
                File outputFile = new File(deCompressPath + entry.getName());
                // 判断文件夹是否存在
                if (!outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                inputStream = zipFile.getInputStream(entry);
                fileOutputStream = new FileOutputStream(outputFile);
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer,0,len);
                }
            }
            log.info("success");
        }catch (Exception e){
            log.error("deCompress zip file error,reason:{}",e.getMessage());
        }
    }

    /**
     * 顺序访问 (流式) 一个一个文件访问 可以控制是否解压 (节省内存)
     * @param zipFilePath  zip文件路径
     * @param deCompressPath    解压路径
     * @param files  要解压出来的文件名   如果为null则解压全部文件
     */
    public static void deCompressOrder(String zipFilePath,String deCompressPath,String...files){
        try {
            // 参数解析
            Boolean isAll = Boolean.FALSE;
            if (null == files || files.length == 0){
                isAll = Boolean.TRUE;
            }
            List<String> fileNames = Arrays.asList(files);
            // 构造zip
            File zipFile = new File(zipFilePath);
            // 构造输入流
            ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(new FileInputStream(zipFile));
            byte[] buffer = new byte[4096];
            // 依次获取文件
            ZipArchiveEntry zipArchiveEntry;
            FileOutputStream fileOutputStream;
            while ((zipArchiveEntry = zipArchiveInputStream.getNextZipEntry()) != null){
                if (!isAll && !fileNames.contains(zipArchiveEntry.getName())){
                    continue;
                }
                File file = new File(deCompressPath + zipArchiveEntry.getName());
                if (!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
                int len = 0;
                while ((len = zipArchiveInputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer,0,len);
                }
                fileOutputStream.close();
            }
            zipArchiveInputStream.close();
            log.info("success");
        }catch (Exception e){
            log.error("deCompress zip file error,reason:{}",e.getMessage());
        }
    }

}
