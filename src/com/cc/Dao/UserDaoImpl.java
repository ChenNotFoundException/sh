package com.cc.Dao;

import com.cc.Action.LoginAction;
import com.cc.entity.User;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/29 10:29
 * @Content:
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
    }



    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void deleteUser(int id) {

        User user = (User) hibernateTemplate.get(User.class, id);
        hibernateTemplate.delete(user);
        System.out.println("删除了 id= "+id+" 的某位");
    }

    @Override
    public boolean addUser(User user) {
        if (!exist(user.getUser())) {
            hibernateTemplate.save(user);
            return true;
        }
        return false;
    }



    @Override
    public void updateUser(int id,String newPaw) {
        System.out.println("···更新密码中···");
        User user = hibernateTemplate.get(User.class, id);
        System.out.println("拿到用户"+user.getUser());
        user.setPaw(newPaw);
        hibernateTemplate.update(user);
        System.out.println("···密码更新完成···");

    }

    @Override
    public boolean exist(String username) {
        System.out.println("是否存在？验证中。。。。");
        List <User> list = (List <User>) hibernateTemplate.find("from User u where u.user = ?0", username);
        return list.isEmpty() ? false : true;
    }

    @Override
    public boolean verify(String username, String password) {
        List list = hibernateTemplate.find("select paw from User u where u.user =?0", username);
        return (list.get(0).toString()).equals(password);
    }

    @Override
    public boolean verify(int id, String password) {
        User user = hibernateTemplate.get(User.class, id);
        if (user != null) {
            System.out.println("修改密码用户查询");
            return true;
        }else
        return false;
    }

    @Override
    public List<User> findAll() {
        return (List<User>)hibernateTemplate.find("from User u");
    }
}
