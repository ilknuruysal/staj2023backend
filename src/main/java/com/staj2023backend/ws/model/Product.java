package com.staj2023backend.ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;


//Lombok kutuphanesi annotationu
@Data
//Database'de PRODUCT tablosu oluşturmak için kullanılan annotation
@Entity
public class Product {
//  PRODUCT tablosunun primary key ini id olarak belirlemek için kullanılan annotation
    @Id
//  id yi sistemin üretip güncellemesi için kullanılan annotation
//  diger variableler columnlar
    @GeneratedValue
    private Long id;
    @NotBlank
    private String productName;
    @NotBlank
    private Long productCategoryID;
    @NotBlank
    private BigDecimal productPrice;
    @NotBlank
    private String productColor;
    @NotBlank
    private Long productStock;
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCategoryID='" + productCategoryID + '\'' +
                ", productPrice=" + productPrice +
                ", productColor='" + productColor + '\'' +
                ", productStock=" + productStock +
                '}';
    }



    public Product(Long id,
                   String productName,
                   Long productCategoryID,
                   BigDecimal productPrice,
                   String productColor,
                   Long productStock){
        this.id = id;
        this.productName = productName;
        this.productCategoryID = productCategoryID;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productStock = productStock;
    }

    public Product() {

    }


}
