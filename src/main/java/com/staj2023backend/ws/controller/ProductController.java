package com.staj2023backend.ws.controller;

import com.staj2023backend.ws.controller.model.ProductID;
import com.staj2023backend.ws.model.Product;
import com.staj2023backend.ws.model.ProductRepository;
import com.staj2023backend.ws.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
import com.staj2023backend.ws.shared.GenericResponse;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/product/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setProductPrice(updatedProduct.getProductPrice());
            productToUpdate.setProductColor(updatedProduct.getProductColor());
            productToUpdate.setProductStock(updatedProduct.getProductStock());

            productRepository.save(productToUpdate);

            return ResponseEntity.ok(productToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        Optional<Product> productToDelete = productRepository.findById(id);

        if (productToDelete.isPresent()) {
            productRepository.delete(productToDelete.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
