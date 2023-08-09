package com.backend.yarenproject.userinfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // lomboktan gelen annotation sayesinde getter setter toString gibi yapılar otomatik oluşur.
@Entity // bunun bir db tablosu olduğunu belirtir
@Table(name = "Users") // User keyword listesinde olduğu için tablo ismi olarak kullanılamaz o yüzden bu şekilde değiştirdik

public class User
{
    @Id
    @GeneratedValue // hibernate id olarak belirtir
    private long id;

    private String username;
    private String display_name;
    private String password;

    // toString --> json dosyasını maplemesi için oluşturuldu
}
