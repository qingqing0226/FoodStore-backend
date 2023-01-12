package se.salt.FoodStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private JpaProductRepository jpaProductRepository;

    public List<Product> getAll() {
        return Streamable.of(jpaProductRepository.findAll()).toList();
    }

    public Product saveProduct(Product product) {
        return jpaProductRepository.save(product);
    }
}
