package se.salt.FoodStore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.salt.FoodStore.order.dto.CreateOrderDTO;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}")
    ResponseEntity getAllOrdersForUser(@PathVariable long userId) {
        try {
            List<Order> orders = orderService.getOrdersForUser(userId);
            return ResponseEntity.ok(orders);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }

    }



    @PostMapping
    ResponseEntity createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        try {
            Order saved = orderService.createOrder(createOrderDTO);
            return ResponseEntity.created(URI.create("/api/orders/" + saved.getId())).body(saved);
        } catch(NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }


}
