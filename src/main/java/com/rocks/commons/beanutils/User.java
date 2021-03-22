package com.rocks.commons.beanutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 测试实例对象
 * @author lizhaoxuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private Date createTime;

    private BigDecimal money;

    private Product product;

    private List<String> extendInfos;

}
