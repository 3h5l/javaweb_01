package com.hl;


import com.hl.pojo.Dept;
import com.hl.service.DeptService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootTest
class Javaweb01ApplicationTests {

    @Autowired
    private DeptService deptService;

    @Test
    void contextLoads() {
        List<Dept> allDept = deptService.getAllDept();
        System.out.println(allDept);
    }

    @Test
    public void testJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "hahfjajfkfafakfa")//签名算法
                .setClaims(claims)//自定义内容()
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有限时间
                .compact();//
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("hahfjajfkfafakfa")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MDUxNzEwMX0.Av-5SWqM6Ln7d4Lau77SmXm5GlYw4icMyqo8QuL6v5M")
                .getBody();
        System.out.println(claims);
    }


}
