package com.backend.yarenproject.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator <UniqueUsername,String> // username string olduğu için
{
    @Autowired
    UserRepository userRepository;

    // Bu method implement edilmek zorundadır
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext)
    {
        User user = userRepository.findByUsername(username);

        if(user != null) // db içinde mevcutsa anlamına gelir
            return false;

        return true;
    }
}