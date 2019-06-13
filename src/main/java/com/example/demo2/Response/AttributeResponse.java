package com.example.demo2.Response;

import com.example.demo2.entity.GoodAttribute;

import java.util.List;

public class AttributeResponse {
    private GoodAttribute goodAttribute;
   private List<GoodAttribute> goodChildAttribute;

    public GoodAttribute getGoodAttribute() {
        return goodAttribute;
    }

    public void setGoodAttribute(GoodAttribute goodAttribute) {
        this.goodAttribute = goodAttribute;
    }

    public List<GoodAttribute> getGoodChildAttribute() {
        return goodChildAttribute;
    }

    public void setGoodChildAttribute(List<GoodAttribute> goodChildAttribute) {
        this.goodChildAttribute = goodChildAttribute;
    }
}
