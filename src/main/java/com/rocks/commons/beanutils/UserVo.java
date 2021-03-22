package com.rocks.commons.beanutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 测试对象实例
 * @author lizhaoxuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserVo {

    private Long id;

    private String username;

    private Integer age;

    private Date createTime;

    private String desc;

    private Product product;

    private List<String> extendInfos;
}
