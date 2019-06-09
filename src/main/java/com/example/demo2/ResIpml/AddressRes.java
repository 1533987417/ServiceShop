package com.example.demo2.ResIpml;

import com.example.demo2.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRes  extends JpaRepository<Address,Long>{

       List<Address> getByUserIdAndAddressStatus(Long userId,Long Status);
}
