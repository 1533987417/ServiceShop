package com.example.demo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.beans.DefaultProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
public class Comments implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idcomments;
  private String comment;
  private String commentUrl;
  private Integer commentUserId;
  private Integer commentHasPic;

  public Integer getCommentHasPic() {
    return commentHasPic;
  }

  public void setCommentHasPic(Integer commentHasPic) {
    this.commentHasPic = commentHasPic;
  }

  public Integer getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(Integer commentUserId) {
    this.commentUserId = commentUserId;
  }

  @OneToMany(cascade={ CascadeType.ALL })
  @JoinColumn(name = "imageUid",referencedColumnName = "commentUrl")
  private List<Images> commentPics;

  public List<Images> getCommentPics() {
    return commentPics;
  }

  public void setCommentPics(List<Images> commentPics) {
    this.commentPics = commentPics;
  }

  private String commentUserName;
  private String commentUserIcon;
  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp commentDate;
  private long commentStatus;
  private long commentGid;
  public  Comments(){}


  public Long getIdcomments() {
    return idcomments;
  }

  public void setIdcomments(Long idcomments) {
    this.idcomments = idcomments;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getCommentUrl() {
    return commentUrl;
  }

  public void setCommentUrl(String commentUrl) {
    this.commentUrl = commentUrl;
  }


  public String getCommentUserName() {
    return commentUserName;
  }

  public void setCommentUserName(String commentUserName) {
    this.commentUserName = commentUserName;
  }


  public String getCommentUserIcon() {
    return commentUserIcon;
  }

  public void setCommentUserIcon(String commentUserIcon) {
    this.commentUserIcon = commentUserIcon;
  }


  public java.sql.Timestamp getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(java.sql.Timestamp commentDate) {
    this.commentDate = commentDate;
  }


  public long getCommentStatus() {
    return commentStatus;
  }

  public void setCommentStatus(long commentStatus) {
    this.commentStatus = commentStatus;
  }


  public long getCommentGid() {
    return commentGid;
  }

  public void setCommentGid(long commentGid) {
    this.commentGid = commentGid;
  }

}