package com.product.management.controller;

import com.product.management.Product;
import com.product.management.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    // With Spring Boot 3+ you don’t actually need @Autowired on constructors,
    // but keeping it is harmless.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);  // ⬅ capital H & S
        // or: return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
