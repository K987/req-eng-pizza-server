package hu.reqeng.pizza.service;

import hu.reqeng.pizza.model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final Map<String, Item> itemDao = new HashMap<>();

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(new ArrayList<>(itemDao.values()));
    }

    @Override
    public Item findItem(String itemId) {
        return itemDao.get(itemId);
    }

    @Override
    public List<Item> findItems(Item.TypeEnum type) {
        return itemDao.values().stream()
                .filter(item -> type.equals(item.getType()))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        itemDao.put("pizza-1", new Item("pizza-1", "margherita", Item.TypeEnum.FOOD, new BigDecimal(2)));
        itemDao.put("pizza-2", new Item("pizza-2", "diablo", Item.TypeEnum.FOOD, new BigDecimal(3)));
        itemDao.put("bev-1", new Item("bev-1", "coke", Item.TypeEnum.BEVERAGE, new BigDecimal(1)));
        itemDao.put("bev-2", new Item("bev-2", "beer", Item.TypeEnum.BEVERAGE, new BigDecimal(1)));
    }
}
