package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Love;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.LoveMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ILoveService;
import com.cy.store.service.ex.*;
import com.cy.store.vo.LoveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoveServiceImpl implements ILoveService {
    @Autowired
    private LoveMapper loveMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addToLove(Integer uid, Integer pid, String username) {
        if(loveMapper.findByPid(pid) == null){
            Love love = new Love();
            love.setUid(uid);
            love.setPid(pid);
            Product product = productMapper.findById(pid);
            love.setPrice(product.getPrice());
            love.setCreatedTime(new Date());
            love.setCreatedUser(username);
            love.setModifiedTime(new Date());
            love.setModifiedUser(username);
            Integer rows = loveMapper.insert(love);
            if(rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }
    }

    @Override
    public void deleteByPid(Integer pid, Integer uid) {
        Love result = loveMapper.findByPid(pid);
        if(result == null){
            throw new LoveNotFoundException("收藏不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = loveMapper.deleteByPid(pid);
        if(rows != 1){
            throw new DeleteException("删除数据产生未知异常");
        }
    }

    @Override
    public boolean findByPid(Integer pid) {
        Love result = loveMapper.findByPid(pid);
        if(result != null){
            return true;
        }

        return false;
    }

    @Override
    public List<LoveVo> getVOByUid(Integer uid) {
        return loveMapper.findVOByUid(uid);
    }

    @Override
    public void addToCart(Integer uid, Integer pid, Integer num, String username) {
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        if(result == null){
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(num);
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedTime(new Date());
            cart.setCreatedUser(username);
            cart.setModifiedTime(new Date());
            cart.setModifiedUser(username);
            Integer rows = cartMapper.insert(cart);
            if(rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }else{
            Integer num2 = result.getNum() + num;
            Integer rows = cartMapper.updateNumByCid(result.getCid(), num2, username, new Date());
            if(rows != 1){
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }
}
