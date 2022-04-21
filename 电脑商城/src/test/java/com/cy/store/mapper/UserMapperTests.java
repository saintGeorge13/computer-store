package com.cy.store.mapper;


import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


//标注当前的类为测试类，不会和项目一起打包
@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

//    必须被@Test注解
//    返回类型为void
//    必须public
//    参数列表不指定类型

    //测试插入一个新用户
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("tim");
        System.out.println(user);
    }
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(1, "321", "管理员", new Date());
    }
    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(1));
    }
    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(02);
        user.setPhone("12312312312");
        user.setEmail("123@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }
    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(02, "/upload/avator.png", "管理员", new Date());
    }
}
