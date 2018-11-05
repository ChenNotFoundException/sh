package com.cc.utils;

import java.util.List;

public class PageBean {
    private List list;

    private int allRow;
    private int totalPage;
    private int currentPage;
    private int pageSize;

    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getAllRow() {
        return allRow;
    }

    public void setAllRow(int allRow) {
        this.allRow = allRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFirstPage() {
        return currentPage == 1;
    }

    public boolean isLastPage() {
        return currentPage == totalPage;
    }

    public boolean isHasPreviousPage() {
        return currentPage != 1;
    }

    public boolean isHasNextPage() {
        return currentPage != totalPage;
    }

    public void init() {
        this.isFirstPage = isFirstPage();
        this.isLastPage = isLastPage();
        this.hasPreviousPage = isHasPreviousPage();
        this.hasNextPage = isHasNextPage();
    }

    /**
     * 计算总页数
     */
    public static int countTotalPage(final int pageSize, final int allRow) {
        int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        return totalPage;
    }

    /**
     * 计算当前页开始的纪录
     * offset为角标。从0开始计数
     */
    public static int countOffset(final int pageSize, final int currentPage) {
        final int offset = pageSize * (currentPage - 1);
        return offset;
    }

    /**
     * 计算当前页 若为0或者请求的URL中没有"?page=",则用1代替
     */
    public static int countCurrentPage(int page) {
        final int curPage = (page == 0 ? 1 : page);
        return curPage;
    }

    @Override
    public String toString() {
        return "PageBean{allRow=" + allRow +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
