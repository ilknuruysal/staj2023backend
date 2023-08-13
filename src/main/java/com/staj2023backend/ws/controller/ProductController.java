package com.staj2023backend.ws.controller;

import com.staj2023backend.ws.controller.model.ProductID;
import com.staj2023backend.ws.model.Product;
import com.staj2023backend.ws.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.staj2023backend.ws.shared.GenericResponse;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product(1L,
                "Ürün1",
                new BigDecimal("258.33"),
                "Siyah",
                26L));

        result.add(new Product(2L,
                "Ürün2",
                new BigDecimal("999.11"),
                "Beyaz",
                84L));

        result.add(new Product(3L,
                "Ürün3",
                new BigDecimal("758.64"),
                "Mavi",
                43L));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product(888L,
                "Ürün adı değiştirme",
                new BigDecimal("458.44"),
                "Yeşil",
                178L);
    }

    @PatchMapping("/product")
    public void patchProduct(@RequestBody final Product product){
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id) {
        System.out.println(id);
    }

}
