package com.example.demo2.ResIpml;

import com.example.demo2.entity.GoodAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodAttributeRes extends JpaRepository<GoodAttribute,Long> {
    List<GoodAttribute> getGoodAttributesByAttributeGoodIdAndAndAttributeStatus(Long goodId,Long status);
    GoodAttribute getByIdgoodAttributeAndAndAttributeStatus(Long id,Long status);
}
