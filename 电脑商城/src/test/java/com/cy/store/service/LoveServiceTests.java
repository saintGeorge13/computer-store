package com.cy.store.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoveServiceTests {

    @Autowired
    private ILoveService loveService;

    @Test
    public void addToLove(){
        loveService.addToLove(2, 10000017, "test02");
    }
    @Test
    public void deleteByLid(){
        loveService.deleteByPid(20, 2);
    }

    @Test
    public void addToCart(){
       loveService.addToCart(2, 10000025, 1, "test02");
    }

}
