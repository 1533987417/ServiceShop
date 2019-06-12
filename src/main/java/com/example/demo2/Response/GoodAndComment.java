package com.example.demo2.Response;

import com.example.demo2.entity.Comments;
import com.example.demo2.entity.Goods;

import java.util.List;

public class GoodAndComment {
    private Goods good;
    private List<Comments> comment;

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public List<Comments> getComment() {
        return comment;
    }

    public void setComment(List<Comments> comment) {
        this.comment = comment;
    }
}
