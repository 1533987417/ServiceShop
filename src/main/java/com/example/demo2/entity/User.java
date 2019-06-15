package com.example.demo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idUser;
  private String avatar;
  private String nickname;
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String moblie;
  private long levelId;
  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp updatetime;
  private long gender;
  @JsonIgnore
  private long password;

  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JoinColumn(updatable = false)
  private java.sql.Timestamp createtime;
  @JsonIgnore
  private String openId;

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public User(){}

  public long getIdUser() {
    return idUser;
  }

  public void setIdUser(long idUser) {
    this.idUser = idUser;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getMoblie() {
    return moblie;
  }

  public void setMoblie(String moblie) {
    this.moblie = moblie;
  }


  public long getLevelId() {
    return levelId;
  }

  public void setLevelId(long levelId) {
    this.levelId = levelId;
  }


  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public long getPassword() {
    return password;
  }

  public void setPassword(long password) {
    this.password = password;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
