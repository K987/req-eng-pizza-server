package hu.reqeng.pizza.service;

import hu.reqeng.pizza.exception.OfferServiceException;
import hu.reqeng.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@Service
public class BeverageOfferServiceImpl implements OfferService {

    private static final String OFFER_PREFIX = "offer-";

    private static final BigDecimal OFFER_THRESHOLD = new BigDecimal(30);

    private final Map<String, Supplier<Cart>> offerDao = new ConcurrentHashMap<>();

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @Override
    public Cart chooseOffer(String offerId, String itemId) throws OfferServiceException {
        Supplier<Cart> supplier = offerDao.get(offerId);
        if (supplier == null) {
            throw new OfferServiceException("Offer not exists", 404);
        }
        Cart cart = supplier.get();
        if (cart == null) {
            throw new IllegalStateException("Cart not exists");
        }
        if (cart instanceof OfferSubject) {
            OfferSubject offerableCart = (OfferSubject) cart;
            if (offerableCart.hasOffer()) {
                throw new OfferServiceException("Offer expired", 410);
            }
            offerableCart.addOffer(createOfferItem(itemId));
            offerDao.remove(offerId);
        }
        return cart;
    }

    private SingleOfferItem createOfferItem(String itemId) throws OfferServiceException {
        Item item = itemService.findItem(itemId);
        if (!Item.TypeEnum.BEVERAGE.equals(item.getType())) {
            throw new OfferServiceException("Only beverage", 404);
        } else {
            return new SingleOfferItem(item);
        }

    }

    @Override
    public Offer getOfferIfAny(String cartId) {
        Cart cart = cartService.findCart(cartId);
        if (cart != null && OFFER_THRESHOLD.compareTo(cart.getTotal()) > 0) {
            if (cart instanceof OfferSubject && ((OfferSubject)cart).hasOffer()) {
                return null;
            }
            Offer offer = new Offer().id(generateOfferId()).offerings(itemService.findItems(Item.TypeEnum.BEVERAGE));
            offerDao.put(offer.getId(), () -> cartService.findCart(cartId));
            return offer;
        }
        return null;
    }

    @Override
    public boolean isOffering(CartItem item) {
        return item instanceof SingleOfferItem;
    }

    private String generateOfferId() {
        return OFFER_PREFIX + IdGenerator.randomString();
    }
}
