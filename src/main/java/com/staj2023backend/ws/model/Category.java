package com.staj2023backend.ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//Lombok kutuphanesi annotationu
@Data
//Database'de CATEGORY tablosu oluşturmak için kullanılan annotation
@Entity
public class Category {
//  CATEGORY tablosunun primary key ini id olarak belirlemek için kullanılan annotation
    @Id
//  id yi sistemin üretip güncellemesi için kullanılan annotation
//  diger variableler columnlar
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
