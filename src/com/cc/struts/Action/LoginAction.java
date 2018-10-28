package com.cc.struts.Action;

import com.cc.hibernate.POJO.LoginInfo;
import com.cc.hibernate.POJO.User;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String execute() {
        if (flag()) {
            System.out.println("登陆成功");
            return SUCCESS;
        } else {
            System.out.println("登陆失败");
            return "fail";

        }
    }

    public String register() {
        LoginInfo info = new LoginInfo();
        return info.NewrRegister(this.username, this.password);
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
