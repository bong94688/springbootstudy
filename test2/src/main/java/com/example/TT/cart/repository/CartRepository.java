package com.example.TT.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TT.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
