package com.rocks.commons.io.output;

import lombok.SneakyThrows;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 *  TeeOutputStream示例
 * @author lizhaoxuan
 */
public class TeeOutputStreamDemo {

    @SneakyThrows
    public static void main(String[] args) {
        String msg = "Output Data By TeeInputStream!";
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        TeeOutputStream teeOutputStream = new TeeOutputStream(byteArrayOutputStream1, byteArrayOutputStream2);
        TeeInputStream teeInputStream = new TeeInputStream(new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)),teeOutputStream);
        teeInputStream.read(new byte[msg.length()]);
        System.out.println(byteArrayOutputStream1.toString());
        System.out.println(byteArrayOutputStream2.toString());
    }

}
