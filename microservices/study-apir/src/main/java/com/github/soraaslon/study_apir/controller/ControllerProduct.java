package com.github.soraaslon.study_apir.controller;

import com.github.soraaslon.study_apir.model.Product;
import com.github.soraaslon.study_apir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody Product product) {
        Product productCreated = productService.createProduct(product);
        return ResponseEntity.status(201).body(productCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = productService.deleteProduct(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product>
    update(@PathVariable Long id, @RequestBody Product product) {

        return productService.updateProduct(id, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
