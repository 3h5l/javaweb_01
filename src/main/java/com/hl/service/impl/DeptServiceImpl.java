package com.hl.service.impl;


import com.hl.mapper.DeptMapper;
import com.hl.mapper.EmpMapper;
import com.hl.pojo.Dept;
import com.hl.pojo.DeptLog;
import com.hl.service.DeptLogService;
import com.hl.service.DeptService;
import com.hl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    @Autowired
    private DeptMapper deptMapper;

    @Resource
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> getAllDept() {
        List<Dept> allDept = deptMapper.getAllDept();
        return allDept;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//spring事务管理
    public void deleteById(Integer id) {
        try {
            deptMapper.deleteById(id);
//            int i = 1/0;
            empMapper.deleteById(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是" + id + "号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void edit(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.edit(dept);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }
}
