package se.salt.FoodStore.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salt.FoodStore.user.User;

@RestController
@CrossOrigin
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    ResponseEntity getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @PostMapping
    ResponseEntity createCart(@RequestBody User user) {
        return ResponseEntity.ok(cartService.createCart(user));
    }
}
