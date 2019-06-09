package com.example.demo2.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@Where(clause = "imagesStatus=0")
public class Images   implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idImages;
  private String imageUid;
  private String imagesUrl;
  private long imagesStatus;

 public Images(){

 }
  public long getIdImages() {
    return idImages;
  }

  public void setIdImages(long idImages) {
    this.idImages = idImages;
  }


  public String getImageUid() {
    return imageUid;
  }

  public void setImageUid(String imageUid) {
    this.imageUid = imageUid;
  }


  public String getImagesUrl() {
    return imagesUrl;
  }

  public void setImagesUrl(String imagesUrl) {
    this.imagesUrl = imagesUrl;
  }


  public long getImagesStatus() {
    return imagesStatus;
  }

  public void setImagesStatus(long imagesStatus) {
    this.imagesStatus = imagesStatus;
  }

}
