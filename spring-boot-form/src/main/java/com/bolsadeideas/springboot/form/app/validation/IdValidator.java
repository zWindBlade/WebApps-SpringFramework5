package com.bolsadeideas.springboot.form.app.validation;

import com.bolsadeideas.springboot.form.app.validation.annotation.IdRegex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdRegex, String> {

    @Override
    public void initialize(IdRegex constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.matches("[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")){
          return true;
        }
        return false;
    }
}
