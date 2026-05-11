package com.nguyenvanhao.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvanhao.ecommerce_backend.models.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Integer>{

}
