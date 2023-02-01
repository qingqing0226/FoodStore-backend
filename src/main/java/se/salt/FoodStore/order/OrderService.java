package se.salt.FoodStore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.FoodStore.item.Item;
import se.salt.FoodStore.item.ItemService;
import se.salt.FoodStore.order.dto.CreateOrderDTO;
import se.salt.FoodStore.product.Product;
import se.salt.FoodStore.product.ProductService;
import se.salt.FoodStore.user.User;
import se.salt.FoodStore.user.UserService;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductService productService;

    public List<Order> getOrdersForUser(long userId) {
        User user = userService.getById(userId);
        List<Order> orders = orderRepository.findAll();
        return orders.stream().filter(o -> o.getUser().getId() == userId).toList();
    }

    public Order createOrder(CreateOrderDTO createOrderDTO) {
        // save user
        User user = createOrderDTO.user();
        User userInDB = userService.getByEmail(user.getEmail());
        userInDB.setName(user.getName());
        userInDB.setEmail(user.getEmail());
        userInDB.setAddress(user.getAddress());
        userInDB.setPhone(user.getPhone());
        User saved = userService.createUser(userInDB);
        // save items
        List<Item> items = createOrderDTO
                .createItemDTOList()
                .stream()
                .map(dto -> {
                    Product p = dto.product();
                    p.setStock(p.getStock() - dto.amount());
                    Product savedP = productService.save(p);
                    return itemService.saveItem(new Item(savedP, dto.amount()));
                }).toList();
        Order saveOrder = orderRepository.save(new Order(saved, items));
        return saveOrder;
    }
}
