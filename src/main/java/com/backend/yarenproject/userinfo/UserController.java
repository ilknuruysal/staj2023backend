package com.backend.yarenproject.userinfo;

import com.backend.yarenproject.common.GenericResponse;
import com.backend.yarenproject.error.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.GenericArrayType;
import java.util.HashMap;
import java.util.Map;

@RestController // springe görevini belli eder
public class UserController
{
    // public static final Logger Log = LoggerFactory.getLogger(UserController.class); --> system.out yerine, daha düzgün data tutar

    @Autowired // dependency injection
    UserService userService;

    // @CrossOrigin --> host uyumsuzluğu olmasın diye eklenir, proxy ekleyince silindi
    @PostMapping("/api/1.0/users")  // bunun restful servis in post methodu ile çalışacağını belirtir
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody User user) // gelen requestin body bilgisini alır
    {
        // Log.info(user.toString());

        if(user.getUsername() == null || user.getUsername().isEmpty())
        {
            ApiError error = new ApiError(400, "ValidationError", "api/1.0/users");

            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("username","Username cannot be null");
            error.setValidationErrors(validationErrors);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // error kısmını eklemeden önce .build yazıyordu
        }

        userService.save(user); // create olduğu için save i çağırdık

        return ResponseEntity.ok(new GenericResponse("messsage created"));
        /* Bunun yerine üstteki kısmı yaparız
        GenericResponse resp = new GenericResponse();
        resp.setMessage(user.toString());
        return resp;
        */
    }

//    public void createUser(@RequestBody User user) // gelen requestin body bilgisini alır
//    {
//        // Log.info(user.toString());
//
//        userService.save(user); // create olduğu için save i çağırdık
//    }
}
