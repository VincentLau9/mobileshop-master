package com.mobileshop.group8.exception;
import com.mobileshop.group8.model.Product;
public class NotEnoughProductsInStockException extends Exception{
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotEnoughProductsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInStockException(Product product) {
        super(String.format("Not enough %s products in stock. Only %d left", product.getProductName(), product.getQuantity()));
    }

}
