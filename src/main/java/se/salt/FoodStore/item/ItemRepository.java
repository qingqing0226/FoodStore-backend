package se.salt.FoodStore.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    @Autowired
    private JpaItemRepository jpaItemRepository;

    public Item save(Item item) {
        return jpaItemRepository.save(item);
    }
}
