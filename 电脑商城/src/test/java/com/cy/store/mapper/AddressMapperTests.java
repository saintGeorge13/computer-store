package com.cy.store.mapper;


import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(1);
        address.setPhone("12312312312");
        address.setName("test01");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid(){
        Integer rows = addressMapper.countByUid(23);
        System.out.println(rows);
    }

    @Test
    public void findByUid(){
        System.out.println(addressMapper.findByUid(2));
    }
    @Test
    public void findByAid(){
        System.out.println(addressMapper.findByAid(7));
    }
    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(2);
    }
    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(7, "test02", new Date());
    }
    @Test
    public void deleteByAid(){addressMapper.deleteByAid(4);}
    @Test
    public void findLastModified(){System.out.println( addressMapper.findLastModified(2));}

}
