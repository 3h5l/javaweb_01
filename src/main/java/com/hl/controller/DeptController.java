package com.hl.controller;

import com.hl.anno.Log;
import com.hl.pojo.Dept;
import com.hl.pojo.Result;
import com.hl.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAllDept(){
        List<Dept> allDept = deptService.getAllDept();
        log.info("查询全部部门数据");
        return Result.success(allDept);
    }

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    @Log
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        deptService.deleteById(id);
        log.info("根据id删除部门:{}",id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        log.info("新增部门: ",dept);
        return Result.success();
    }

    /**
     * 编辑更新部门信息
     * @param dept
     * @return
     */
    @Log
    @PutMapping
    public Result edit(@RequestBody Dept dept){
        deptService.edit(dept);
        log.info("编辑功能");
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

}
