package com.cy.store.mapper;



import com.cy.store.entity.Cart;
import com.cy.store.entity.Love;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.spi.CharsetProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoveMapperTests {
    @Autowired
    private LoveMapper loveMapper;

    @Test
    public void insert(){
        Love love = new Love();
        love.setUid(2);
        love.setPid(20);
        love.setPrice(2000L);
        Integer rows = loveMapper.insert(love);
        System.out.println("rows=" + rows);
    }

    @Test
    public void deleteByPid(){
        loveMapper.deleteByPid(20);
    }

    @Test
    public void findVOByUid(){
         System.out.println(loveMapper.findVOByUid(2));
    }
    @Test
    public void addToCartByPid(){
        Cart cart = new Cart();
        cart.setUid(2);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        loveMapper.addToCartByPid(cart);
    }

}
