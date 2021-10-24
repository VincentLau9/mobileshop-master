package com.mobileshop.group8.service;

import com.mobileshop.group8.common.Constants;
import com.mobileshop.group8.exception.NotEnoughProductsInStockException;
import com.mobileshop.group8.model.Product;
import com.mobileshop.group8.model.cart.Cart;
import com.mobileshop.group8.model.cart.CartBean;
import com.mobileshop.group8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {
    @Autowired
    private ProductRepository productRepository;



    public void checkout(HttpSession session) throws NotEnoughProductsInStockException {

        CartBean cartbean = (CartBean) session.getAttribute(Constants.ATTR_CART);
        if (cartbean!=null) {
            for (Object object : cartbean.values()) {
                // Refresh quantity for every product before checking
                Cart cart = (Cart)object;
                cart.setProduct(productRepository.findByProductId(cart.getProduct().getProductId()));
                Product product = cart.getProduct();
                if (product.getQuantity()<cart.getQuantity())
                    throw new NotEnoughProductsInStockException(cart.getProduct());
                product.setQuantity(product.getQuantity() - cart.getQuantity());
                productRepository.save(product);
            }
            productRepository.flush();
        }
    }



}
