package com.der.customAnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOf12Or48Validator implements ConstraintValidator<ValueOf12Or48, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        return value == 12 || value == 48;
    }
}

