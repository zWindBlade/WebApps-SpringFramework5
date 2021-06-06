package com.bolsadeideas.springboot.form.app.validation.annotation;

import com.bolsadeideas.springboot.form.app.validation.IdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = IdValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface IdRegex {

    String message() default "Id is not valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
