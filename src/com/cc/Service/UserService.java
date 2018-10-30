package com.cc.Service;

import com.cc.Dao.UserDao;

import com.cc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/29 10:38
 * @Content:
 */
@Transactional(readOnly =false)
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean loginVerify(String username, String password) {
        boolean pass = false;
        System.out.println("验证。。。。");
        pass = userDao.exist(username);
        if (pass) {
            pass = userDao.verify(username, password);
            System.out.println("验证密码。。。。");
        }
        System.out.println("登录。。。。");
        return pass;
    }

    public boolean userRegister(String username, String password) {
        User user = new User();
        user.setUser(username);
        user.setPaw(password);
        System.out.println("注册。。。。");
        return userDao.addUser(user);
    }
    public List<User> find(){
        return userDao.findAll();
    }

}
