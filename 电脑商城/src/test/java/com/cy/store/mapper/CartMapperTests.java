package com.cy.store.mapper;


import com.cy.store.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(2);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1, 4, "test02", new Date());
    }

    @Test
    public void findByUidAndPid(){
        cartMapper.findByUidAndPid(2, 10000011);
    }
    @Test
    public void findVOByUid(){
        cartMapper.findVOByUid(2);
    }

    @Test
    public void findVoByCid(){
        Integer cids[] = {1,3,5};
        cartMapper.findVOByCid(cids);
    }

    @Test
    public void findByCid(){
        cartMapper.findVOByUid(1);
    }

}
