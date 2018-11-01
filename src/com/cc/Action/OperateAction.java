package com.cc.Action;

import com.cc.Service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenchen
 * @date 2018/10/31 14:35
 * @Content:
 */
public class OperateAction extends ActionSupport {
    private int id;
    private String password;
    private String username;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private UserService service;

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String delete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getAttribute("username");
        service.deleteUserById(this.id);

        return SUCCESS;
    }

    public String update() {
        HttpServletRequest request = ServletActionContext.getRequest();
//        System.out.println( request.getParameterMap());
        this.setUsername((String)request.getSession().getAttribute("username"));
        service.update((int)(request.getSession().getAttribute("id")),this.password);
        return SUCCESS;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
