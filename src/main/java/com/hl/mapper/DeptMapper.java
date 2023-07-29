package com.hl.mapper;

import com.hl.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> getAllDept();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void edit(Dept dept);

    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
