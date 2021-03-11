package com.rocks.commons.io.input;

import lombok.SneakyThrows;
import org.apache.commons.io.input.TeeInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 *  TeeInputStream示例
 * @author lizhaoxuan
 */
public class TeeInputStreamDemo {

    @SneakyThrows
    public static void main(String[] args)  {
        String msg = "Output Data By TeeInputStream!";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // TeeInputStream可以自动将输入流的内容转给输出流 第三个参数设置为true代表读取完后自动关闭流
        TeeInputStream teeInputStream = new TeeInputStream(new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)),byteArrayOutputStream,true);
        teeInputStream.read(new byte[msg.length()]);
        System.out.println(byteArrayOutputStream.toString());
    }

}
