package com.cy.store.mapper;


import com.cy.store.entity.Cart;
import com.cy.store.entity.Love;
import com.cy.store.entity.Product;
import com.cy.store.vo.CartVo;
import com.cy.store.vo.LoveVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoveMapper {
    Integer insert(Love love);

    Integer deleteByPid(Integer pid);

    Love findByPid(Integer pid);

    List<LoveVo> findVOByUid(Integer uid);

    Integer addToCartByPid(Cart cart);
}
