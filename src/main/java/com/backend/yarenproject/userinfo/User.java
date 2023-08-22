package com.backend.yarenproject.userinfo;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Data // Lombok tan gelen annotation sayesinde getter setter toString gibi yapılar otomatik oluşur
@Entity // Bu classın bir db tablosu olduğunu belirtir
@Table(name = "Users") // "User" keyword listesinde olduğu için tablo ismi olarak kullanılamaz o yüzden değiştirilir
public class User
{
    @Id
    @GeneratedValue // Hibernate id olarak belirtir
    private long id;

    @NotNull
    @Size(min = 3 , max = 255)
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 2 , max = 255)
    private String display_name;

    @NotNull
    @Size(min = 8 , max = 255)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).*$") // d digit i temsil eder
    private String password;

    // toString --> json dosyasını maplemesi için oluşturuldu
}