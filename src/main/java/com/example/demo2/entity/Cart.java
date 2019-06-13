package com.example.demo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idcart;
  @Column(updatable=false)
  private long cartUserId;
  @Column(updatable=false)
  private String cartGoodAttributeValue;
  private long cartGoodCount;
  private long cartGoodStatus;
  @Column(updatable=false)
  private long cartGoodId;
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

  public String getCartGoodAttributeValue() {
    return cartGoodAttributeValue;
  }

  public void setCartGoodAttributeValue(String cartGoodAttributeValue) {
    this.cartGoodAttributeValue = cartGoodAttributeValue;
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
}
