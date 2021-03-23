package com.rocks.commons.lang3;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 * lang3包其他工具类
 * @author lizhaoxuan
 */
public class OtherUtilsDemo {

    public static void main(String[] args) throws InterruptedException {

        // 秒表
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(RandomUtils.nextLong(3*1000,10*1000));
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
        System.out.println(stopWatch.getNanoTime());

    }

}
