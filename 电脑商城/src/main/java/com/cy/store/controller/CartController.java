package com.cy.store.controller;

import com.cy.store.entity.Cart;
import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addTocart(Integer pid, Integer num, HttpSession session){
        cartService.addToCart(getuidFromSession(session), pid, num, getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
    @RequestMapping({"", "/"})
    public JsonResult<List<CartVo>> getVOByUid(HttpSession session){
        List<CartVo>list = cartService.getVoByUid(getuidFromSession(session));
        return new JsonResult<>(OK, list);
    }
    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer data = cartService.addNum(cid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, data);
    }
    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer data = cartService.reduceNum(cid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, data);
    }
    @RequestMapping("list")
    public JsonResult<List<CartVo>> getVOByCid(Integer cids[], HttpSession session){
        List<CartVo> data = cartService.getVOByCid(getuidFromSession(session), cids);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{cid}/delete")
    public JsonResult<Void> deleteByPid(@PathVariable("cid")Integer cid, HttpSession session){
        cartService.deleteByCid(cid, getuidFromSession(session));
        return new JsonResult<>(OK);
    }
}
