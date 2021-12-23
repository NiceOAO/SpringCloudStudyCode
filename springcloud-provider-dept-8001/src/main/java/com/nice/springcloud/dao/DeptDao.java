package com.nice.springcloud.dao;

import com.nice.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
//    新增部门
    boolean addDept(Dept dept);
//    查询部门
    Dept queryDeptById(Long id);
//    查询所有部门
    List<Dept> queryAll();
}
