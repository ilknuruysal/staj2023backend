package com.backend.yarenproject.userinfo;

import com.backend.yarenproject.common.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.GenericArrayType;

@RestController // springe görevini belli eder
public class UserController
{
    // public static final Logger Log = LoggerFactory.getLogger(UserController.class); --> system.out yerine, daha düzgün data tutar

    @Autowired // dependency injection
    UserService userService;

    // @CrossOrigin --> host uyumsuzluğu olmasın diye eklenir, proxy ekleyince silindi
    @PostMapping("/api/1.0/users")  // bunun restful servis in post methodu ile çalışacağını belirtir
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@RequestBody User user) // gelen requestin body bilgisini alır
    {
        // Log.info(user.toString());

        userService.save(user); // create olduğu için save i çağırdık

        /* Bunun yerine alt kısmı yaparız
        GenericResponse resp = new GenericResponse();
        resp.setMessage(user.toString());
        return resp;
        */

        return new GenericResponse("messsage created");

    }
//    public void createUser(@RequestBody User user) // gelen requestin body bilgisini alır
//    {
//        // Log.info(user.toString());
//
//        userService.save(user); // create olduğu için save i çağırdık
//    }
}
