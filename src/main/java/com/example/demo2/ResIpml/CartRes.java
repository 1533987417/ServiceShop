package com.example.demo2.ResIpml;

import com.example.demo2.entity.Address;
import com.example.demo2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRes  extends JpaRepository<Cart,Long> {
    List<Cart> getAllByCartUserIdAndCartGoodStatus(Long userId,Long satus);
}
