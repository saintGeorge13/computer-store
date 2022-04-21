package com.cy.store.service;

import com.cy.store.vo.LoveVo;

import java.util.List;

public interface ILoveService {
    void addToLove(Integer uid, Integer pid, String username);

    void deleteByPid(Integer pid, Integer uid);

    boolean findByPid(Integer pid);

    List<LoveVo> getVOByUid(Integer uid);

    void addToCart(Integer uid, Integer pid, Integer num, String username);
}
