package com.nice.springcloud.controller;

import com.nice.springcloud.pojo.Dept;
import com.nice.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @PostMapping("/dept/save")
    public boolean saveDept(@RequestBody Dept dept){
        return deptService.saveDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept findDeptById(@PathVariable("id") Long id){
        return deptService.findDeptById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

}
