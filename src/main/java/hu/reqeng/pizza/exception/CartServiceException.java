package hu.reqeng.pizza.exception;

import hu.reqeng.pizza.model.Cart;

public class CartServiceException extends ServiceException {

    private final Cart cart;

    public CartServiceException(int code, String message, Cart cart) {
        super(message, code);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }
}
