package se.salt.FoodStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salt.FoodStore.product.dto.CreateProductDTO;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    ResponseEntity createProduct(@RequestBody CreateProductDTO createProductDTO) {
        Product created = productService.createProduct(createProductDTO);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId())).body(created);
    }

    @PostMapping("/list")
    ResponseEntity createProducts(@RequestBody List<CreateProductDTO> createProductDTOs) {
        List<Product> created =createProductDTOs.stream().map(dto -> productService.createProduct(dto)).toList();
        return ResponseEntity.created(URI.create("/api/products/")).body(created);
    }
}
