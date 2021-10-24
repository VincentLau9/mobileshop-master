package com.mobileshop.group8.repository;

import com.mobileshop.group8.model.OrderDetail;
import com.mobileshop.group8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
