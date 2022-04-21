package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;
    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("12312312313");
        address.setName("test02");
        addressService.addNewAddress(1, "test02", address);
    }
    @Test
    public void setDefault(){
        addressService.setDefault(7, 2, "test02");
    }
    @Test
    public void deleteByAid(){
        addressService.deleteByAid(5, 2, "test02");
    }
    @Test
    public void changeByAid(){
        addressService.changeByAid(10, 2, "test02");
    }
}
