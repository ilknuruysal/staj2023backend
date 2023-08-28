package com.staj2023backend.ws.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
//Lombok kutuphanesi annotationu
@Data
//Database'de SELLING tablosu oluşturmak için kullanılan annotation
@Entity
public class Selling {

//  SELLING tablosunun primary key ini id olarak belirlemek için kullanılan annotation
    @Id
//  id yi sistemin üretip güncellemesi için kullanılan annotation
//  diger variableler columnlar
    @GeneratedValue
    private Long id;
    @NotBlank
    private Long productID;
    private Long costumerID;
    @NotBlank
    private Long numberOfProduct;






}
