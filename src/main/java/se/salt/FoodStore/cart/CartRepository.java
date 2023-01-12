package se.salt.FoodStore.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import se.salt.FoodStore.user.User;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private JpaCartRepository jpaCartRepository;

    public List<Cart> findAll() {
        return Streamable.of(jpaCartRepository.findAll()).toList();
    }

    public Cart createCart(User user) {
        return jpaCartRepository.save(new Cart(user));
    }
}
