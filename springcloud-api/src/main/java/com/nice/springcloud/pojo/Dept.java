package com.nice.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

// Dept 实体类， orm 类表关系映射
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
    /*
        链式写法
        Dept dept = new Dept();
        dept.setDeptNo().setDeptName().setDeptDbSource();
    */

    // 主键 部门编号
    private Long deptNo;
    // 部门名称
    private String deptName;
    // 数据所在的数据库，一个服务对应一个数据库 同一个信息可能存在不同的数据库
    private String dbSource;


}
