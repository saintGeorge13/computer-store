package com.cy.store.service;


import com.cy.store.entity.User;

import java.awt.print.PrinterGraphics;

//用户模块业务层接口
public interface IUserService {
    //注册
    void reg(User user);
    //登录，将当前登录用户数据以当前用户对象形式返回。
    //状态管理：可以将数据保存在session或者cookie中，可以避免频繁提取同一数据，session存用户名，cookie存头像
    User login(String username, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    User getByUid(Integer uid);

    void changeInfo(Integer uid, String username, User user);

    void changeAvatar(Integer uid, String avatar, String username);
}
