package com.example.demo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idcart;
  private long cartUserId;
  private String cartGoodName;
  private String cartGoodIcon;

  public String getCartGoodIcon() {
    return cartGoodIcon;
  }

  public void setCartGoodIcon(String cartGoodIcon) {
    this.cartGoodIcon = cartGoodIcon;
  }

  private long cartGoodCount;
  private long cartGoodStatus;
  private long cartGoodId;
  private long cartGoodPrice;

  public Cart(){}
  public long getIdcart() {
    return idcart;
  }

  public void setIdcart(long idcart) {
    this.idcart = idcart;
  }


  public long getCartUserId() {
    return cartUserId;
  }

  public void setCartUserId(long cartUserId) {
    this.cartUserId = cartUserId;
  }


  public String getCartGoodName() {
    return cartGoodName;
  }

  public void setCartGoodName(String cartGoodName) {
    this.cartGoodName = cartGoodName;
  }


  public long getCartGoodCount() {
    return cartGoodCount;
  }

  public void setCartGoodCount(long cartGoodCount) {
    this.cartGoodCount = cartGoodCount;
  }


  public long getCartGoodStatus() {
    return cartGoodStatus;
  }

  public void setCartGoodStatus(long cartGoodStatus) {
    this.cartGoodStatus = cartGoodStatus;
  }


  public long getCartGoodId() {
    return cartGoodId;
  }

  public void setCartGoodId(long cartGoodId) {
    this.cartGoodId = cartGoodId;
  }


  public long getCartGoodPrice() {
    return cartGoodPrice;
  }

  public void setCartGoodPrice(long cartGoodPrice) {
    this.cartGoodPrice = cartGoodPrice;
  }

}
