package com.cy.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class ProductMapperTests {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void findHotList(){
        System.out.println(productMapper.findHotList());
    }
    @Test
    public void findById(){
        System.out.println(productMapper.findById(10000017));
    }

    @Test
    public void findNewList(){
        System.out.println(productMapper.findNewList());
    }
}
