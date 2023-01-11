package se.salt.FoodStore.product;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private double price;

    private String image;

    private long stock;

    private Section section;

    public Product() {
    }

    public Product(long id, double price, String image, long stock, Section section) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.section = section;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}

enum Section {
    FRUITS_VEGES, DRINKS, MEAT, DIARY, DRY_FOOD, BREAD, SNACKS
}
