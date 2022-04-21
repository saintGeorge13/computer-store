package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.*;
import com.cy.store.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

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

    @Override
    public List<CartVo> getVoByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new CartNotFoundException("尝试访问的购物车数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问");
        }
        Integer num = result.getNum() + 1;
        int rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if(rows != 1){
            throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
        }
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if (result == null) {
            throw new CartNotFoundException("尝试访问的购物车数据不存在");
        }

        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }

        Integer num = result.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1) {
            throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
        }
        return num;
    }

    @Override
    public List<CartVo> getVOByCid(Integer uid, Integer[] cids) {
        List<CartVo>list =  cartMapper.findVOByCid(cids);
        for(CartVo item : list){
            if(!item.getUid().equals(uid)){
                list.remove(item);
            }
        }
        return list;
    }

    @Override
    public void deleteByCid(Integer cid, Integer uid) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new CartNotFoundException("尝试访问的购物车数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = cartMapper.deleteByCid(cid);
        if(rows != 1){
            throw new DeleteException("删除数据产生未知异常");
        }
    }
}
