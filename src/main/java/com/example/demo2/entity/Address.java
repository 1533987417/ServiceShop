package com.example.demo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private long userId;
  private String country;
  private String province;
  private String city;
  private long districtId;
  private String address;
  private String mobile;
  private long isDefault;
  private long addressStatus;
  /**
   *
   */
  private long addressType;
  public Address(){

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }



  public long getDistrictId() {
    return districtId;
  }

  public void setDistrictId(long districtId) {
    this.districtId = districtId;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public long getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(long isDefault) {
    this.isDefault = isDefault;
  }


  public long getAddressStatus() {
    return addressStatus;
  }

  public void setAddressStatus(long addressStatus) {
    this.addressStatus = addressStatus;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public long getAddressType() {
    return addressType;
  }

  public void setAddressType(long addressType) {
    this.addressType = addressType;
  }

}
