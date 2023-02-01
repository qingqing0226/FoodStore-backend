package se.salt.FoodStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.FoodStore.product.dto.CreateProductDTO;
import se.salt.FoodStore.section.Section;
import se.salt.FoodStore.section.SectionService;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SectionService sectionService;


    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product createProduct(CreateProductDTO createProductDTO) {
        Section section = sectionService.findByName(createProductDTO.section());
        return productRepository.saveProduct(new Product(createProductDTO.name(), createProductDTO.price(), createProductDTO.image(), createProductDTO.stock(), section));
    }

    public Product save(Product product) {
        return productRepository.saveProduct(product);
    }
}
