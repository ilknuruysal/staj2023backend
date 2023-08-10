package com.staj2023backend.ws.user;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.staj2023backend.ws.shared.Views;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import com.staj2023backend.ws.shared.Views;
import jakarta.validation.constraints.NotBlank;
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

//    @JsonView(Views.Base.class)
//    private String images;

}
