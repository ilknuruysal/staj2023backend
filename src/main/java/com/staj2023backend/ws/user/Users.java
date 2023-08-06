package com.staj2023backend.ws.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
@Entity
public class Users {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank (message = "{staj2023backend.constraints.username.NotBlank.message}")
    @Size(min=4, max=255)
    @UniqueUsername
    private String username;

    @NotBlank (message = "{staj2023backend.constraints.displayName.NotBlank.message}")
    @Size(min=4, max=255)
    private String displayName;

    @NotBlank (message = "{staj2023backend.constraints.password.NotBlank.message}")
    @Size(min=8, max=255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{staj2023backend.constraints.password.pattern.message}")
    private String password;






}
