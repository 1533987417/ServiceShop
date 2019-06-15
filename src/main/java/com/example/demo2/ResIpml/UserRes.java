package com.example.demo2.ResIpml;

import com.example.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRes extends JpaRepository<User,Long> {
    User getUserByOpenId(String openId);
}
