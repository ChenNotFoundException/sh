package com.cc.Action;

import com.cc.Service.UserService;
import com.cc.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenchen
 * @date 2018/11/2 15:35
 * @Content:
 */
public class PageAction extends ActionSupport {
    private int page;
    private PageBean pageBean;
    private UserService service;

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getPageList() {
        HttpServletRequest request = ServletActionContext.getRequest();

        this.pageBean = service.queryForPage(6, page);
        request.setAttribute("page", pageBean);
        return SUCCESS;
    }
}
