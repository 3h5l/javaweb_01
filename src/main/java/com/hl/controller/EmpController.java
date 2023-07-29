package com.hl.controller;

import com.hl.pojo.Emp;
import com.hl.pojo.PageBean;
import com.hl.pojo.Result;
import com.hl.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


/**
 * 员工管理Controller
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;


    /**
     * 通过@RequestParam(defaultValue = "1")来设置参数的默认值
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        PageBean pageBean = empService.page(page,pageSize,begin,end,name,gender);
        log.info("参数：{},{},{},{}",page,pageSize,begin,end);
        return Result.success(pageBean);

    }


    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){
            empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Emp emp =empService.selectById(id);
        log.info("查询的id为：{}\n 员工信息为：{}",id,emp);
        return Result.success(emp);
    }

    @PutMapping
    public Result edit(@RequestBody Emp emp){
        empService.edit(emp);
        log.info("要修改的员工信息为：{}",emp);
        return Result.success();
    }

}
