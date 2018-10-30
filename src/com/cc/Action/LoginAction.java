package com.cc.Action;

import com.cc.Dao.UserDao;
import com.cc.Service.UserService;
import com.cc.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.omg.CORBA.Request;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginAction extends ActionSupport {


    private UserService userService;
    private String username;
    private String password;
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

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
            list= userService.find();
            this.setList(list);
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

        return flag;

    }
}
