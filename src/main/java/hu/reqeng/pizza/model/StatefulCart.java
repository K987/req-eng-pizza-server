package hu.reqeng.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StatefulCart extends Cart implements OfferSubject {

    public enum State {
        INIT,
        DIRTY,
        OFFERING_SELECTED;
    }

    @JsonIgnore
    private State state = State.INIT;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void addOffer(CartItem item) {
        if (!hasOffer()) {
            addItemsItem(item);
        }
        this.setState(State.OFFERING_SELECTED);
    }

    @Override
    public Cart addItemsItem(CartItem itemsItem) {
        setState(State.DIRTY);
        return super.addItemsItem(itemsItem);
    }

    @Override
    public void setItems(List<CartItem> items) {
        setState(State.DIRTY);
        super.setItems(items);
    }

    @Override
    public boolean hasOffer() {
        return State.OFFERING_SELECTED.equals(this.getState());
    }


}
