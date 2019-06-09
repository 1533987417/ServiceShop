package com.example.demo2.Response;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T> {
    private Long totalCount;
    private Long totalPage;

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    private List<T> data;
    public PageResponse(List data, Long totalCount, int totalPage){
        this.totalCount=totalCount;
        this.totalPage= Long.valueOf(totalPage);
        this.data=data;
    }
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
