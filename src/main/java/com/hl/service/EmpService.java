package com.hl.service;

import com.hl.pojo.Emp;
import com.hl.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize, LocalDate begin, LocalDate end,  String name, Short gender);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp selectById(Integer id);

    void edit(Emp emp);

    Emp  login(Emp emp);
}
