package se.salt.FoodStore.product;

import jakarta.persistence.*;
import se.salt.FoodStore.section.Section;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String name;

    private double price;

    private String image;

    private long stock;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Product() {
    }

    public Product(String name, double price, String image, long stock, Section section) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.section = section;
    }

    public Product(long id, String name, double price, String image, long stock, Section section) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

/*
enum Section {
    FRUITS_VEGES, DRINKS, MEAT, DIARY, DRY_FOOD, BREAD, SNACKS
}

 */
