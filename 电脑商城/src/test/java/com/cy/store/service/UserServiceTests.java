package com.cy.store.service;


import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//标注当前的类为测试类，不会和项目一起打包
@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService userService;

//    必须被@Test注解
//    返回类型为void
//    必须public
//    参数列表不指定类型

    //测试插入一个新用户
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("test02");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        User user = userService.login("test02", "123");
        System.out.println(user);
    }
    @Test
    public void changePassword(){
        userService.changePassword(2, "管理员", "123", "321");
    }
    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(02));
    }
    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("12312312313");
        user.setEmail("321@qq.com");
        user.setGender(0);
        userService.changeInfo(02, "管理员",  user);
    }
    @Test
    public void changeAvatar(){
        userService.changeAvatar(2, "/upload/test.png", "管理员");
    }
}
