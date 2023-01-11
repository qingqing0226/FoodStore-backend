package se.salt.FoodStore.cart;
import jakarta.persistence.*;
import se.salt.FoodStore.item.Item;
import se.salt.FoodStore.user.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", fetch=FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    private boolean paid = false;

    public Cart() {
    }

    public Cart(long id, User user, List<Item> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getTotal() {
        double sum = 0;
        for(Item item: items) {
            sum += item.getProduct().getPrice() * item.getAmount();
        }
        return sum;
    }
}
