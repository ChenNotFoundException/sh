package com.cc.Dao;

import com.cc.hibernate.POJO.User;

/**
 * @author chenchen
 * @date 2018/10/29 10:24
 * @Content:
 */
public interface UserDao {

    public boolean addUser(User user);

    public boolean exist(String username);

    public boolean verify(String username, String password);
}
