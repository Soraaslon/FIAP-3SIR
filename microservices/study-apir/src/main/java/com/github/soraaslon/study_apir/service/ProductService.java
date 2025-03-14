package com.github.soraaslon.study_apir.service;

import com.github.soraaslon.study_apir.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private Long sequence = 1L;

    public Product createProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
        return product;
    }

    public Product getProductById(Long id) {
        return null;
    }

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> updateProduct(Long id, Product product) {

        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                            p.setNome(product.getNome());
                            return p;
                        }
                );
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
