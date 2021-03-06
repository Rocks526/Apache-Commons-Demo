package com.rocks.commons.codec;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import java.nio.charset.StandardCharsets;

/**
 * 运算摘要 && 编码解码示例代码
 * @author lizhaoxuan
 */
public class Demo {

    public static void main(String[] args) throws EncoderException, DecoderException {

        // Base64
        Base64 base64 = new Base64();
        String base64Str = base64.encodeToString("hello world".getBytes(StandardCharsets.UTF_8));
        System.out.println(base64Str);
        String str = base64.encodeToString(base64Str.getBytes(StandardCharsets.UTF_8));
        System.out.println(str);

        // MD5 SHA等摘要
        String md5Hex = DigestUtils.md5Hex("Rocks");
        System.out.println(md5Hex);
        String sha1Hex = DigestUtils.sha1Hex("Rocks");
        System.out.println(sha1Hex);
        String sha256Hex = DigestUtils.sha256Hex("Rocks");
        System.out.println(sha256Hex);

        // URL编解码
        URLCodec urlCodec = new URLCodec();
        String encodeUrl = urlCodec.encode("http://www.baidu.com");
        System.out.println(encodeUrl);
        String url = urlCodec.decode(encodeUrl);
        System.out.println(url);
    }

}
