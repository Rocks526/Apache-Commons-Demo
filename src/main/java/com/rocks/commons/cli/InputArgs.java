package com.rocks.commons.cli;


import lombok.Data;

/**
 * 输入参数解析
 * @author lizhaoxuan
 */
@Data
public class InputArgs {

    private Integer eps = 10000;
    private Boolean isMulti = Boolean.FALSE;
    private String encoding = "UTF-8";
    private String topic = "basp";
    private int sendTime = 15;
    private String devIp = "";
    private String collectIp = "";
    private String logPath = "";
    private String host = "127.0.0.1";
    private String port = "9092";


}
