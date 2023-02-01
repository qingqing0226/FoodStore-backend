package se.salt.FoodStore.item;

import org.springframework.data.repository.CrudRepository;

public interface JpaItemRepository extends CrudRepository<Item, Long> {
}
