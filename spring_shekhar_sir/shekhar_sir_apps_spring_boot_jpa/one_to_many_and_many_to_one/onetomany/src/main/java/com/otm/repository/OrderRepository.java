package com.otm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otm.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
