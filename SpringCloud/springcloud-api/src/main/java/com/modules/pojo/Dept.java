package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 链式写法
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long id;
    private String dname;
    private String dbSource;

}
