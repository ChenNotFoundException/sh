package com.cc.Dao;

import com.cc.hibernate.POJO.User;
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
    public boolean addUser(User user) {
        if (!exist(user.getUser())) {
            hibernateTemplate.save(user);
            return true;
        }
        return false;
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
}
