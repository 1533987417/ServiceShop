package com.example.demo2.ResIpml;

import com.example.demo2.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRes extends JpaRepository<Region,Long>{
    List<Region> getByParentId(Long pid);
}
