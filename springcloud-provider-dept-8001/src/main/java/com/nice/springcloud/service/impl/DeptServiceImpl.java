package com.nice.springcloud.service.impl;

import com.nice.springcloud.dao.DeptDao;
import com.nice.springcloud.pojo.Dept;
import com.nice.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 对部门的操作
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDao deptDao;
    @Override
    public boolean saveDept(Dept dept) {
        //    新增部门
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findDeptById(Long id) {
        //    查询部门
        return deptDao.queryDeptById(id);
    }

    @Override
    public List<Dept> findAll() {
        //    查询所有部门
        return deptDao.queryAll();
    }
}
