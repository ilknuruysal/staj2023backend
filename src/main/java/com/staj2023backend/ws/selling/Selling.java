package com.staj2023backend.ws.selling;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Selling {


    @Id
    @GeneratedValue
    private Long id;
    private Long productID;
    private Long costumerID;
    private Long numberOfProduct;






}
