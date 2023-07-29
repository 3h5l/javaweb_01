package com.hl.service;

import com.hl.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    List<Dept> getAllDept();

    void deleteById(Integer id);

    void edit(Dept dept);

    void add(Dept dept);

    Dept getById(Integer id);
}
