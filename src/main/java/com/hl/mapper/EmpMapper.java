package com.hl.mapper;


import com.hl.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page( Integer start, Integer pageSize);

    //    @Select("select * from emp")
    List<Emp> list(LocalDate begin, LocalDate end, String name, Short gender);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp selectById(Integer id);

    //    @Update("update emp " +
//            "set username = #{username}, gender = #{gender} , image = #{image},name = #{name} ," +
//            " job = #{job},entrydate = #{entrydate} ,dept_id = #{deptId} ,update_time = #{updateTime} " +
//            "where id = #{id}")
    void edit(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteById(Integer deptId);
}
