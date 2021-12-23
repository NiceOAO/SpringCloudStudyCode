package com.nice.springcloud.service;

import com.nice.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    // 保存部门
    boolean saveDept(Dept dept);
    // 根据部门id查询部门
    Dept findDeptById(Long id);
    // 查询所有部门
    List<Dept> findAll();
}
