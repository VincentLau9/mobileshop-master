package com.mobileshop.group8.controller;

import com.mobileshop.group8.common.Constants;
import com.mobileshop.group8.model.Product;
import com.mobileshop.group8.exception.NotEnoughProductsInStockException;
import com.mobileshop.group8.service.ProductService;
import com.mobileshop.group8.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private ProductService productService;

    //@Autowired
   // private ShoppingCartService shoppingCartService;
    ShoppingCartService shoppingCartService = new ShoppingCartService();

    @RequestMapping(value = "/")
    public ModelAndView index() {
        List<Product> tblProductsList = this.productService.findAll();
        return new ModelAndView(Constants.PRODUCT_LIST_URL, "products", tblProductsList);
    }

    @RequestMapping(value = "/view", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView searchProduct(@RequestParam("id") Integer productId) {
        Product product = this.productService.findByProductId(productId);
        if (product != null) {
            return new ModelAndView(Constants.PRODUCT_DETAIL_URL, "product", product);
        }
        return index();

    }

    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", shoppingCartService.);
        modelAndView.addObject("total", shoppingCartService.getTotal().toString());
        return modelAndView;
    }

    @RequestMapping("/viewcart/checkout")
    public ModelAndView checkout() {

        try {
            shoppingCartService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return shoppingCart().addObject("outOfStockMessage", e.getMessage());
        }
        return shoppingCart();
    }

}
