package com.cy.store.mapper;

import com.cy.store.entity.Address;

import java.util.Date;
import java.util.List;

public interface AddressMapper {
    //插入用户收货地址
    Integer insert(Address address);

    //根据用户uid查询收货地址总数
    Integer countByUid(Integer uid);

    //根据uid查询收货地址
    List<Address> findByUid(Integer uid);

    //根据aid查询收货地址
    Address findByAid(Integer aid);

    //根据用户uid修改用户收货地址为非默认
    Integer updateNonDefault(Integer uid);

    //将aid指定收货地址设置为默认
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

    //根据aid删除收货地址
    Integer deleteByAid(Integer aid);

    //最后一次修改的数据
    Address findLastModified(Integer uid);
}
