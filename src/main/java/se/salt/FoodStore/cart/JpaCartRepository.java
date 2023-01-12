package se.salt.FoodStore.cart;

import org.springframework.data.repository.CrudRepository;

public interface JpaCartRepository extends CrudRepository<Cart, Long> {
}
