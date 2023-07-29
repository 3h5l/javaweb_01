package com.hl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.mapper.EmpMapper;
import com.hl.pojo.Emp;
import com.hl.pojo.PageBean;
import com.hl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Resource()
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;
//    }

    /*使用分页插件pageHelper*/
    @Override
    public PageBean page(Integer page, Integer pageSize, LocalDate begin, LocalDate end,  String name, Short gender) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(begin,end,name,gender);
        Page<Emp> emPage = ( Page<Emp>) empList;

        PageBean pageBean = new PageBean(emPage.getTotal(),emPage.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.add(emp);
    }

    @Override
    public Emp selectById(Integer id) {
       Emp emp =  empMapper.selectById(id);
        return emp;
    }

    @Override
    public void edit(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.edit(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return  empMapper.getByUsernameAndPassword(emp);

    }
}
