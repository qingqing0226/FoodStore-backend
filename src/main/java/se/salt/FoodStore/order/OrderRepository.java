package se.salt.FoodStore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    public List<Order> findAll() {
        return Streamable.of(jpaOrderRepository.findAll()).toList();
    }

    public Order save(Order order) {
        return jpaOrderRepository.save(order);
    }
}
