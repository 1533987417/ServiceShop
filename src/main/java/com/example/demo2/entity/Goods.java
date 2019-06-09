package com.example.demo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idgoods;
  private String goodsName;
  private Long goodsPrice;
  private String goodsDesc;
  private Long goodsSale;
  private Long goodsSaleCount;
  private Long goodsSaleTotal;
  private Long goodsCategoryId;
  private Long goodsStatus;
  private String goodsDeTail;
  private Long goodsIsAct;
  private String goodsIcon;
  private String goodsBanners;

    public String getGoodsBanners() {
        return goodsBanners;
    }

    public void setGoodsBanners(String goodsBanners) {
        this.goodsBanners = goodsBanners;
    }

    @OneToMany(cascade={ CascadeType.ALL })
  @JoinColumn(name = "imageUid",referencedColumnName = "goodsBanners")
  private List<Images> goodsBanner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp goodsCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp goodsUpdateData;

  public Goods(){

 }

    public Long getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(Long idgoods) {
        this.idgoods = idgoods;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Long getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Long goodsSale) {
        this.goodsSale = goodsSale;
    }

    public Long getGoodsSaleCount() {
        return goodsSaleCount;
    }

    public void setGoodsSaleCount(Long goodsSaleCount) {
        this.goodsSaleCount = goodsSaleCount;
    }

    public Long getGoodsSaleTotal() {
        return goodsSaleTotal;
    }

    public void setGoodsSaleTotal(Long goodsSaleTotal) {
        this.goodsSaleTotal = goodsSaleTotal;
    }

    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Long getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Long goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsDeTail() {
        return goodsDeTail;
    }

    public void setGoodsDeTail(String goodsDeTail) {
        this.goodsDeTail = goodsDeTail;
    }

    public Long getGoodsIsAct() {
        return goodsIsAct;
    }

    public void setGoodsIsAct(Long goodsIsAct) {
        this.goodsIsAct = goodsIsAct;
    }

    public String getGoodsIcon() {
        return goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon) {
        this.goodsIcon = goodsIcon;
    }

    public List<Images> getGoodsBanner() {
        return goodsBanner;
    }

    public void setGoodsBanner(List<Images> goodsBanner) {
        this.goodsBanner = goodsBanner;
    }

    public Timestamp getGoodsCreateDate() {
        return goodsCreateDate;
    }

    public void setGoodsCreateDate(Timestamp goodsCreateDate) {
        this.goodsCreateDate = goodsCreateDate;
    }

    public Timestamp getGoodsUpdateData() {
        return goodsUpdateData;
    }

    public void setGoodsUpdateData(Timestamp goodsUpdateData) {
        this.goodsUpdateData = goodsUpdateData;
    }
}
