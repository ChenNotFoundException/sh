package com.cc.Service;

import com.cc.Dao.UserDao;
import com.cc.entity.User;
import com.cc.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteUserById(int id) {
        userDao.deleteUser(id);
    }

    public void update(int id,String newPaw) {
        userDao.updateUser(id, newPaw);
    }

    public List <User> find() {
        return userDao.findAll();
    }

    public PageBean queryForPage(int pageSize, int Page) {
        String hql = "select count(*) from User ";
        int count = userDao.getCount();
        int totalPage = PageBean.countTotalPage(pageSize, count);

        int length = pageSize;
        int currentPage = PageBean.countCurrentPage(Page);
        int offset = PageBean.countOffset(pageSize, currentPage);
        List <User> list = userDao.queryForPage("from User u", offset, length);
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(count);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }
}
