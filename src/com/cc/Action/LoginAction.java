package com.cc.Action;

import com.cc.Service.UserService;
import com.cc.hibernate.POJO.LoginInfo;
import com.cc.hibernate.POJO.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoginAction extends ActionSupport {


    private UserService userService;
    private String username;
    private String password;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public String execute() {
//        if (flag()) {
//            System.out.println("登陆成功");
//            return SUCCESS;
//        } else {
//            System.out.println("登陆失败");
//            return "fail";
//
//        }
        if (userService.loginVerify(username, password)) {
            return SUCCESS;
        }
        return ERROR;
    }

    public String register() {
//        LoginInfo info = new LoginInfo();
//        return info.NewrRegister(this.username, this.password);
        if (userService.userRegister(username, password)) {
            return SUCCESS;
        }
        return ERROR;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean flag() {
        boolean flag=false;
        LoginInfo info = new LoginInfo();
        List list = info.loginQuery(this.getUsername());
        User user = new User();
        for (int i = 0; i < list.size(); i++) {
            user = (User) list.get(i);
            if (this.username.equals(user.getUser()) && this.password.equals(user.getPaw())) {
                flag = true;
            }
        }
        return flag;

    }
}
