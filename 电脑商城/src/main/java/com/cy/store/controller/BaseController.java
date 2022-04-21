package com.cy.store.controller;


import com.cy.store.controller.ex.FileEmptyException;
import com.cy.store.controller.ex.FileSizeException;
import com.cy.store.controller.ex.FileStateException;
import com.cy.store.controller.ex.FileTypeException;
import com.cy.store.entity.Cart;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.rmi.ServerException;

//控制层基类
@RestController
public class BaseController {
    public static final int OK = 200;

    //请求处理方法
    @ExceptionHandler({ServiceException.class, FileUploadIOException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<Void>();
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if(e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        } else if(e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("用户密码错误的异常");
        } else if(e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("用户收货地址超出上限的异常");
        }else if(e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户收货地址不存在的异常");
        }else if(e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("收货地址非法访问的异常");
        }else if(e instanceof ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品不存在的异常");
        }else if(e instanceof CartNotFoundException){
            result.setState(4007);
            result.setMessage("购物车不存在的异常");
        }


        else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("插入数据时产生未知异常");
        } else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新用户数据时出现未知错误");
        }else if(e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除用户数据时出现未知错误");
        }

        else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("头像文件为空");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("头像文件太大");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("头像文件类型错误");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("头像文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("头像文件上传失败");
        }
        return result;
    }
    //获取session对象的uid，当前登录用户uid的值
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    //获取session对象的username，当前登录用户username的值
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }




}
