package se.salt.FoodStore.item;

import jakarta.persistence.*;
import se.salt.FoodStore.cart.Cart;
import se.salt.FoodStore.order.Order;
import se.salt.FoodStore.product.Product;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Item() {
    }

    public Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Item(Product product, int amount, Cart cart, Order order) {
        this.product = product;
        this.amount = amount;
        this.cart = cart;
        this.order = order;
    }

    public Item(long id, Product product, int amount, Cart cart, Order order) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.cart = cart;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
