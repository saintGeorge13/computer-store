package com.cy.store.controller;


import com.cy.store.service.ILoveService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVo;
import com.cy.store.vo.LoveVo;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("loves")
public class LoveController extends BaseController{
    @Autowired
    private ILoveService loveService;

    @RequestMapping("add_to_love")
    public JsonResult<Void> addToLove(Integer pid, HttpSession session){
        loveService.addToLove(getuidFromSession(session), pid, getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_to_love")
    public JsonResult<Void> delete(Integer pid, HttpSession session){
        loveService.deleteByPid(pid, getuidFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("find_by_pid")
    public JsonResult<Boolean> findByPid(Integer pid){
        boolean data = loveService.findByPid(pid);
        return new JsonResult<>(OK, data);
    }
    @RequestMapping({"", "/"})
    public JsonResult<List<LoveVo>> getVOByUid(HttpSession session){
        List<LoveVo>list = loveService.getVOByUid(getuidFromSession(session));
        return new JsonResult<>(OK, list);
    }

    @RequestMapping("{pid}/delete")
    public JsonResult<Void> deleteByPid(@PathVariable("pid")Integer pid, HttpSession session){
        loveService.deleteByPid(pid, getuidFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addTocart(Integer pid, HttpSession session){
        loveService.addToCart(getuidFromSession(session), pid, 1, getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
