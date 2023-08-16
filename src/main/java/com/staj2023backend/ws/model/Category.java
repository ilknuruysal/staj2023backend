package com.staj2023backend.ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category() {

    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", CategoryName='" + categoryName + '\'' +
                '}';
    }



}
