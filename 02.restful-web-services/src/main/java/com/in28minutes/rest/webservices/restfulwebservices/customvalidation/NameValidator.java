package com.in28minutes.rest.webservices.restfulwebservices.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        //^ start of string
        // $ end of string
        //* zero or more  occurance of a-zA-Z of spaces (\\s)
        return name != null && name.matches("^[a-zA-Z\\s]*$");
    }
}
