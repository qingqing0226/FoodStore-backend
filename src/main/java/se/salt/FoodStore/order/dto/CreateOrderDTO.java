package se.salt.FoodStore.order.dto;

import se.salt.FoodStore.item.CreateItemDTO;
import se.salt.FoodStore.user.User;

import java.util.List;

public record CreateOrderDTO(User user, List<CreateItemDTO> items) {
}
