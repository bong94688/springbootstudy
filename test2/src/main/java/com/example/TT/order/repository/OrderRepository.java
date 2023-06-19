package com.example.TT.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TT.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
											
	
}
