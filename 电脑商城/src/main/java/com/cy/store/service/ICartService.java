package com.cy.store.service;

import com.cy.store.vo.CartVo;

import java.util.List;

public interface ICartService {

    void addToCart(Integer uid, Integer pid, Integer num, String username);

    List<CartVo> getVoByUid(Integer uid);

    /*将购物车中某商品的数量加1*/
    Integer addNum(Integer cid, Integer uid, String username);

    /*将购物车中某商品的数量减1*/
    Integer reduceNum(Integer cid, Integer uid, String username);

    List<CartVo> getVOByCid(Integer uid, Integer[] cids);

    void deleteByCid(Integer cid, Integer uid);
}
