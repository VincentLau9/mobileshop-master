package com.mobileshop.group8.repository;

import com.mobileshop.group8.model.Order;
import com.mobileshop.group8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
