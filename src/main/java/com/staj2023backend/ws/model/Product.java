package com.staj2023backend.ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Long productCategoryID;
    private BigDecimal productPrice;
    private String productColor;
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
