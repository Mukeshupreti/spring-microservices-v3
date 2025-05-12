package com.in28minutes.rest.webservices.restfulwebservices.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public abstract class DateValidator implements ConstraintValidator<ValidDate, Date> {
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        return false;
    }
}
