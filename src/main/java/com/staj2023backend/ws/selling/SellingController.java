package com.staj2023backend.ws.selling;

import com.staj2023backend.ws.controller.ProductController;
import com.staj2023backend.ws.controller.model.ProductID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.staj2023backend.ws.model.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SellingController {


    @Autowired
    SellingRepository sellingRepository;


    private ProductRepository productRepository;
    public SellingController(SellingRepository sellingRepository, ProductRepository productRepository) {
        this.sellingRepository = sellingRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/selling")
    public ResponseEntity<Selling> createOrder(@RequestBody Selling selling) {
        System.out.println(selling);
        ProductID result = new ProductID(selling.toString());
        Optional<Product> existingProduct = productRepository.findById(selling.getProductID());

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();

            productToUpdate.setProductStock(productToUpdate.getProductStock()-selling.getNumberOfProduct());

            productRepository.save(productToUpdate);
        }

        sellingRepository.save(selling);
        return ResponseEntity.ok(selling);
    }

    @GetMapping("/selling")
    public List<Selling> getAllSelling() {
        return sellingRepository.findAll();
    }

}
