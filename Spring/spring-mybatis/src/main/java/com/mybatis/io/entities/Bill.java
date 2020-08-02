package com.mybatis.io.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Getter and @Setter
 * @FieldNameConstants
 * @ToString
 * @EqualsAndHashCode
 * @AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
 * @Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
 * @Data
 * @Builder
 * @SuperBuilder
 * @Singular
 * @Delegate
 * @Value
 * @Accessors
 * @Wither
 * @With
 * @SneakyThrows
 * @val
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {

    private Integer bid;
    // 账单编码
    private String billCode;
    // 商品名称
    private String billName;
    // 商品单位
    private String billCom;
    // 商品数量
    private Integer billNum;
    // 总金额
    private Double money;

}
