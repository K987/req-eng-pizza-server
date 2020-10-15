package hu.reqeng.pizza.service;

import hu.reqeng.pizza.exception.CartServiceException;
import hu.reqeng.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartServiceImpl implements CartService {

    public static final String CART_PREFIX = "cart-";

    private static final BigDecimal MIN_PURCHASE_AMT = BigDecimal.TEN;

    private final Map<String, StatefulCart> cartDao = new ConcurrentHashMap<>();

    @Autowired
    private ItemService itemService;

    @Autowired
    private OfferService offerService;

    @Override
    public Cart createCart() {
        String id = generateCartId();
        StatefulCart cart = new StatefulCart();
        cart.setId(id);
        initCart(cart);
        cartDao.put(id, cart);
        return cart;
    }


    @Override
    public Cart findCart(String cartId) {
        return cartDao.get(cartId);
    }

    @Override
    public void clearCart(String cartId) {
        cartDao.computeIfPresent(cartId, (key, cart) -> {
            initCart(cart);
            return cart;
        });
    }

    @Override
    public Cart checkOut(String cartId) throws CartServiceException {
        Cart cart = findCart(cartId);
        if (cart != null && cart.getRemainingToCheckOut().equals(BigDecimal.ZERO)) {
            return cart;
        } else {
            throw new CartServiceException(100, "Total must be above: " + MIN_PURCHASE_AMT, cart);
        }
    }

    @Override
    public Cart changeOrderQty(String cartId, List<ChangeOrderQtyRequest> itemsToChange) throws CartServiceException {
        verifyQuantites(itemsToChange);
        return cartDao.computeIfPresent(cartId, (key, cart) ->  {
            updateCart(itemsToChange, cart);
            calculateCartTotal(cart);
            return cart;
        });
    }



    private void updateCart(List<ChangeOrderQtyRequest> itemsToChange, Cart cart) {
        for (ChangeOrderQtyRequest qtyRequest : itemsToChange) {
            Optional<CartItem> existingItem = cart
                    .getItems()
                    .stream()
                    .filter(i -> i.getId().equals(qtyRequest.getItemId()) && !offerService.isOffering(i))
                    .findFirst();
            if (existingItem.isPresent()) {
                CartItem item = existingItem.get();
                item.setQty(qtyRequest.getQty());
            } else {
                cart.addItemsItem(createNewItem(qtyRequest));
            }
        }
    }

    private void calculateCartTotal(Cart cart) {
        BigDecimal total = cart.getItems().stream().map(CartItem::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotal(total);
        cart.setRemainingToCheckOut(MIN_PURCHASE_AMT.compareTo(total) < 0 ? BigDecimal.ZERO : MIN_PURCHASE_AMT.subtract(total));
    }

    private CartItem createNewItem(ChangeOrderQtyRequest qtyRequest) {
        Item item = itemService.findItem(qtyRequest.getItemId());
        return new CartItem(item, qtyRequest.getQty());
    }

    private void verifyQuantites(List<ChangeOrderQtyRequest> itemsToChange) throws CartServiceException {
        if (itemsToChange.stream().anyMatch(item -> item.getQty() < 0)) {
            throw new CartServiceException(100, "Invalid qty", null);
        }
    }

    private void initCart(StatefulCart cart) {
        cart.getItems().clear();
        cart.setState(StatefulCart.State.INIT);
        cart.setTotal(BigDecimal.ZERO);
        cart.setRemainingToCheckOut(MIN_PURCHASE_AMT);
    }

    private String generateCartId() {
        return CART_PREFIX + IdGenerator.randomString();
    }
}
