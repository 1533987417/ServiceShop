package com.example.demo2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "goodattribute")
public class GoodAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idgoodAttribute;
    private String attributeName;
    private String attributeValue;
    private long attributePrice;
    private long attributePid;
    private long attributeGoodId;
    private long attributeStatus;

    public GoodAttribute(){}
    public long getIdgoodAttribute() {
        return idgoodAttribute;
    }

    public void setIdgoodAttribute(long idgoodAttribute) {
        this.idgoodAttribute = idgoodAttribute;
    }


    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }


    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }


    public long getAttributePrice() {
        return attributePrice;
    }

    public void setAttributePrice(long attributePrice) {
        this.attributePrice = attributePrice;
    }


    public long getAttributePid() {
        return attributePid;
    }

    public void setAttributePid(long attributePid) {
        this.attributePid = attributePid;
    }


    public long getAttributeGoodId() {
        return attributeGoodId;
    }

    public void setAttributeGoodId(long attributeGoodId) {
        this.attributeGoodId = attributeGoodId;
    }


    public long getAttributeStatus() {
        return attributeStatus;
    }

    public void setAttributeStatus(long attributeStatus) {
        this.attributeStatus = attributeStatus;
    }

}
