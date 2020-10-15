package hu.reqeng.pizza.service;

import hu.reqeng.pizza.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item findItem(String itemId);

    List<Item> findItems(Item.TypeEnum beverage);
}
