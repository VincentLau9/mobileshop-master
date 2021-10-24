package com.mobileshop.group8.model.cart;

import java.util.HashMap;

public class CartBean extends HashMap {
    public CartBean() {
        super();
    }

    public void addProduct(Cart cart) {
        int productId = cart.getProduct().getProductId();
        if (this.containsKey(productId)) {
            int oldQuantity = cart.getQuantity();
            ((Cart) this.get(productId)).setQuantity(++oldQuantity);
        } else {
            this.put(productId, cart);
        }
    }

    public boolean removeProduct(int productId) {
        if (this.containsKey(productId)) {
            this.remove(productId);
            return true;
        }
        return false;
    }

}
