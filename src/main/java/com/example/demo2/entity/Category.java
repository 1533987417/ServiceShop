package com.example.demo2.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idCategory;
  @NotNull(message = "分类名不为空")
  private String categoryName;
  @NotNull(message = "分类描述不为空")
  private String categorDesc;

  private String categoryBcgUrl;
  private String categoryIconUrl;
  private long categoryPid;
  private long categoryStatus;
  private long categorySort;
  public Category(){

  }

  public long getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(long idCategory) {
    this.idCategory = idCategory;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public String getCategorDesc() {
    return categorDesc;
  }

  public void setCategorDesc(String categorDesc) {
    this.categorDesc = categorDesc;
  }

  public String getCategoryBcgUrl() {
    return categoryBcgUrl;
  }

  public void setCategoryBcgUrl(String categoryBcgUrl) {
    this.categoryBcgUrl = categoryBcgUrl;
  }

  public String getCategoryIconUrl() {
    return categoryIconUrl;
  }

  public void setCategoryIconUrl(String categoryIconUrl) {
    this.categoryIconUrl = categoryIconUrl;
  }


  public long getCategoryPid() {
    return categoryPid;
  }

  public void setCategoryPid(long categoryPid) {
    this.categoryPid = categoryPid;
  }


  public long getCategoryStatus() {
    return categoryStatus;
  }

  public void setCategoryStatus(long categoryStatus) {
    this.categoryStatus = categoryStatus;
  }


  public long getCategorySort() {
    return categorySort;
  }

  public void setCategorySort(long categorySort) {
    this.categorySort = categorySort;
  }

}
