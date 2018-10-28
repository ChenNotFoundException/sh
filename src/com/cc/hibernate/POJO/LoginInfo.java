package com.cc.hibernate.POJO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;

    public LoginInfo() {
    }

    public List loginQuery(Object value) {
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        try{
            String hqlsql="from User as u where u.user=?1";
            query=session.createQuery(hqlsql);
            query.setParameter(1, value);
            List list=query.list();
            transaction=session.beginTransaction();
            transaction.commit();
            return list;
        }catch(Exception e){
            System.out.println("连接异常");
            e.printStackTrace();
            return null;
        }
    }

    public String NewrRegister(String username, String password) {
        User user = new User();
        user.setUser(username);
        user.setPaw(password);
        String msg = "fail";
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("注册成功");
            msg = "login";
            return msg;
        } catch (Exception e) {
            System.out.println("注册异常");
            e.printStackTrace();
        }
        return msg;
    }
}
