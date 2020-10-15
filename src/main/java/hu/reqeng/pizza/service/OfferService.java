package hu.reqeng.pizza.service;

import hu.reqeng.pizza.exception.OfferServiceException;
import hu.reqeng.pizza.model.Cart;
import hu.reqeng.pizza.model.CartItem;
import hu.reqeng.pizza.model.ChooseOfferRequest;
import hu.reqeng.pizza.model.Offer;

import java.util.List;

public interface OfferService {
    Cart chooseOffer(String offerId, String itemId) throws OfferServiceException;

    Offer getOfferIfAny(String cartId);

    boolean isOffering(CartItem i);
}
