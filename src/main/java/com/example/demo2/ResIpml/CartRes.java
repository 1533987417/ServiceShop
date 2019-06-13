package com.example.demo2.ResIpml;

import com.example.demo2.entity.Address;
import com.example.demo2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRes  extends JpaRepository<Cart,Long> {
    List<Cart> getAllByCartUserIdAndCartGoodStatus(Long userId,Long satus);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="update cart set cartGoodStatus=?1 where idcart=?2")
    void updateStatusCart(Long status,Long cartId);
}
