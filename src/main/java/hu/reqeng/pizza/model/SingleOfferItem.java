package hu.reqeng.pizza.model;

import java.math.BigDecimal;

public class SingleOfferItem extends CartItem {

    public SingleOfferItem(Item item) {
        super(item, 1);
        this.setPrice(BigDecimal.ZERO);
    }

    @Override
    public void setQty(int qty) {
        super.setQty(1);
        setPrice(BigDecimal.ZERO);
    }
}
