package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK);
    }
    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getuidFromSession(session);
        List<Address> list = addressService.getByUid(uid);
        return new JsonResult<>(OK, list);
    }
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
        addressService.setDefault(aid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> deleteByAid(@PathVariable("aid")Integer aid, HttpSession session){
        addressService.deleteByAid(aid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/change")
    public JsonResult<Address> changeByAid(@PathVariable("aid")Integer aid, HttpSession session){
        Address address = addressService.changeByAid(aid, getuidFromSession(session), getUsernameFromSession(session));
        session.setAttribute("aid", aid);
        return new JsonResult<>(OK, address);
    }

    @RequestMapping("get_by_aid")
    public JsonResult<Address> getByAid(HttpSession session){
        if(session.getAttribute("aid") == null) return new JsonResult<>(OK, new Address());
        Address address = addressService.changeByAid( Integer.valueOf(session.getAttribute("aid").toString())
        , getuidFromSession(session), getUsernameFromSession(session));
        System.out.println(Integer.valueOf(session.getAttribute("aid").toString()));
        return new JsonResult<>(OK, address);
    }
}
