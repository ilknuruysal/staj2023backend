package com.backend.yarenproject.userinfo;

import com.backend.yarenproject.common.GenericResponse;
import com.backend.yarenproject.error.ApiError;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.GenericArrayType;
import java.util.HashMap;
import java.util.Map;

@RestController // Spring e görevini belli eder
public class UserController
{
    // public static final Logger Log = LoggerFactory.getLogger(UserController.class); --> System.out yerine daha düzgün data tutar

    @Autowired // Dependency Injection
    UserService userService;

    // @CrossOrigin --> Host uyumsuzluğu olmasın diye eklenir, frontend e proxy ekleyince silindi
    @PostMapping("/api/1.0/users")  // Bunun restful servis in post methodu ile çalışacağını belirtir
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@Valid @RequestBody User user) // Gelen request in body bilgisini alır
    {
        // Log.info(user.toString());

        userService.save(user); // create olduğu için save i çağırdık

        return new GenericResponse("User created");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception)
    {
        ApiError error = new ApiError(400, "ValidationError", "api/1.0/users");
        Map <String,String> validationErrors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors())
        {
            validationErrors.put(fieldError.getField() , fieldError.getDefaultMessage());
        }

        error.setValidationErrors(validationErrors);

        return error;
    }
}