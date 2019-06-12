package com.example.demo2.ResIpml;

import com.example.demo2.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRes extends JpaRepository<Comments,Long>{

}
