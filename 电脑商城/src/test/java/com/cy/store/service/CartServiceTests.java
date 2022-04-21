package com.cy.store.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class CartServiceTests {

    @Autowired
    ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(2, 10000025, 1, "test02");
    }
    @Test
    public void deleteByPid(){
        cartService.deleteByCid(7, 2);
    }


}
