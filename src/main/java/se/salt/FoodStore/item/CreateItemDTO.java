package se.salt.FoodStore.item;

import se.salt.FoodStore.product.Product;

public record CreateItemDTO(Product product, int amount) {
}
