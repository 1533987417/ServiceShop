package com.example.demo2.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
@Entity
@Table(name = "region")
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long parentId;
  private String name;
  private long type;
  private long agencyId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getAgencyId() {
    return agencyId;
  }

  public void setAgencyId(long agencyId) {
    this.agencyId = agencyId;
  }

}
