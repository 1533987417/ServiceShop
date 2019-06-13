package com.example.demo2.Response;

import com.example.demo2.entity.Cart;

public class CartResponse extends Cart {
    private String checkedAttribute;
    private long price;
    private String goodName;
    private long isValid;

    public long getIsValid() {
        return isValid;
    }

    public void setIsValid(long isValid) {
        this.isValid = isValid;
    }

    public String getGoodIcon() {
        return goodIcon;
    }

    public void setGoodIcon(String goodIcon) {
        this.goodIcon = goodIcon;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }


    private String goodIcon;

    public String getCheckedAttribute() {
        return checkedAttribute;
    }

    public void setCheckedAttribute(String checkedAttribute) {
        this.checkedAttribute = checkedAttribute;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
