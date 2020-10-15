package hu.reqeng.pizza.model;

import java.math.BigDecimal;

public class CartItem extends Item {

    private int qty;

    private BigDecimal subtotal;

    public CartItem(Item item, Integer qty) {
        this.id(item.getId()).name(item.getName()).type(item.getType()).price(item.getPrice());
        this.setQty(qty);
    }

    public int getQty() {
        return qty;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setQty(int qty) {
        this.qty = qty;
        subtotal = getPrice().multiply(new BigDecimal(qty));
    }
}
