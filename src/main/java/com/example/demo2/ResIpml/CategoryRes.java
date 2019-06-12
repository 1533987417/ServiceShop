package com.example.demo2.ResIpml;

import com.example.demo2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRes extends JpaRepository<Category,Long> {
    List<Category>  getAllByCategoryPidAndCategoryStatusOrderByCategorySort(Long id,Long Status);
}
