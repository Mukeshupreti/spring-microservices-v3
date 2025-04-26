package com.in28minutes.rest.webservices.restfulwebservices.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {

    String message() default "Name must not contain numbers";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

