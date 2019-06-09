package com.example.demo2.ResIpml;

import com.example.demo2.entity.Goods;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRes extends JpaRepository<Goods,Long> {
    List<Goods> getGoodsByGoodsCategoryId(Long cateGoryId, Pageable pageable);

}
