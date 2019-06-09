package com.example.demo2.Request;

import javafx.beans.DefaultProperty;

public class GetGoodsRequest  {

    private Integer pageIndex;
    private Integer pageSize;
    private Integer categoryId;
    private String goodsName;
    private Integer goodStatus;
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
