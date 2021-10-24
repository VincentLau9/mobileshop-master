package com.mobileshop.group8.controller;

import com.mobileshop.group8.model.Order;
import com.mobileshop.group8.model.OrderDetail;
import com.mobileshop.group8.model.Product;
import com.mobileshop.group8.model.cart.Cart;
import com.mobileshop.group8.model.cart.CartBean;
import com.mobileshop.group8.repository.OrderDetailRepository;
import com.mobileshop.group8.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;

public class ShoppingCartController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(HttpServletRequest request, HttpSession session){
        Order order = new Order();


        CartBean cartBean = (CartBean) session.getAttribute("CART");
        // Add new order
        order.setDate((Timestamp) new Date());
        order.setTotal(Double.parseDouble(request.getParameter("total")));
        order = orderRepository.save(order);
        for (Object object : cartBean.values() ){

            OrderDetail orderDetail = new OrderDetail();
            Cart cart = (Cart) object;
            Product product = cart.getProduct();
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setQuantity(cart.getQuantity());
            orderDetail.setPrice(product.getPrice());
            orderDetail.setProductId(product.getProductId());
            orderDetailRepository.save(orderDetail);
        }
        return "";
}
