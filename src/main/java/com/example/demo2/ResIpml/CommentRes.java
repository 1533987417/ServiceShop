package com.example.demo2.ResIpml;

import com.example.demo2.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRes extends JpaRepository<Comments,Long>{
}
