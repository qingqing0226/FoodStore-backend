package se.salt.FoodStore.product.dto;


public record CreateProductDTO(String name, double price, String image, long stock, String section) {
}
