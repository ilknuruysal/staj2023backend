package com.staj2023backend.ws.controller;

import com.staj2023backend.ws.controller.model.ProductID;
import com.staj2023backend.ws.model.*;
import com.staj2023backend.ws.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/category/product/{ProductCategoryID}")
    public List<Product> getProductByCategory(@PathVariable Long ProductCategoryID) {
        List<Product> product = productRepository.findAll();
        for(int i = 0; i < product.size(); i++) {
            if (product.get(i).getProductCategoryID()==(ProductCategoryID)) {
                continue;
            } else {
                product.remove(i);
            }
        }
        return product;
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

    @PostMapping("/category")
    public ResponseEntity<ProductID> createCategory(@RequestBody Category category) {
        System.out.println(category);
        //change this
        ProductID result = new ProductID(UUID.randomUUID().toString());
        categoryRepository.save(category);
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


    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @PatchMapping("/product/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setProductCategoryID(updatedProduct.getProductCategoryID());
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
