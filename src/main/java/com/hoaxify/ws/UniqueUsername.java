package com.hoaxify.ws;

import jakarta.validation.Constraint;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import org.hibernate.validator.internal.constraintvalidators.hv.UniqueElementsValidator;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueElementsValidator.class} )
public @interface UniqueUsername {
}
