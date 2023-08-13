package com.staj2023backend.ws.model;

import com.staj2023backend.ws.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
