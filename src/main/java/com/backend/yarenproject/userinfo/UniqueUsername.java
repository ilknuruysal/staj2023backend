package com.backend.yarenproject.userinfo;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername
{
    String message() default "Username must be unique"; // Api içinde görünen mesaj
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}