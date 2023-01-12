package se.salt.FoodStore.product;

import org.springframework.data.repository.CrudRepository;

public interface JpaProductRepository extends CrudRepository<Product, Long> {
}
