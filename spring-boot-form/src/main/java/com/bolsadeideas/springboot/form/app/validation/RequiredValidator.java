package com.bolsadeideas.springboot.form.app.validation;

import com.bolsadeideas.springboot.form.app.validation.annotation.Required;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator <Required, String>  {

    @Override
    public void initialize(Required constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !StringUtils.hasText(s) ? false : true;
    }
}
