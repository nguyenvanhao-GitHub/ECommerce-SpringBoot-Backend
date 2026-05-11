package com.nguyenvanhao.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenvanhao.ecommerce_backend.models.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
