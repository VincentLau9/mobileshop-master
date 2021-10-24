package com.mobileshop.group8.service;

import com.mobileshop.group8.model.Product;
import com.mobileshop.group8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public List<Product> findByProductName(String productName){
        return this.productRepository.findByProductName(productName);
    }

    public Product findByProductId(Integer productId){
        return this.productRepository.findByProductId(productId);
    }
}
