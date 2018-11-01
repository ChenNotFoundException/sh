package com.cc.Dao;

import com.cc.entity.User;

import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/29 10:24
 * @Content:
 */
public interface UserDao {

    public boolean addUser(User user);

    public boolean exist(String username);

    public boolean verify(String username, String password);
    public boolean verify(int id, String password);

    public void deleteUser(int id);

    public void updateUser(int id,String newPaw);

    public List<User> findAll();
}
