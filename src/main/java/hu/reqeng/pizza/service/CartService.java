package hu.reqeng.pizza.service;

import hu.reqeng.pizza.exception.CartServiceException;
import hu.reqeng.pizza.model.Cart;
import hu.reqeng.pizza.model.ChangeOrderQtyRequest;
import hu.reqeng.pizza.model.Offer;

import java.util.List;

public interface CartService {
    Cart createCart();

    Cart findCart(String cartId);

    void clearCart(String cartId);

    Cart checkOut(String cartId) throws CartServiceException;

    Cart changeOrderQty(String cartId, List<ChangeOrderQtyRequest> itemsToChange) throws CartServiceException;

}
