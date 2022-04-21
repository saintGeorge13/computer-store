package com.cy.store.mapper;


import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> list = districtMapper.findByParent("220000");
        for(District d: list){
            System.out.println(d);
        }
    }

    @Test
    public void findNameByCode(){
        System.out.println(districtMapper.findNameByCode("130000"));
    }
}
