package com.bolsadeideas.springboot.form.app.controllers;

import com.bolsadeideas.springboot.form.app.models.domain.User;
import com.bolsadeideas.springboot.form.app.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(userValidator);
    }

    @GetMapping({"/form", "/"})
    public String form (Model model) {
        model.addAttribute("titulo","Formulario de choro");
        model.addAttribute("user", new User("12.456.789-K","Jhon","Doe"));
        return "index_form";
    }

    @PostMapping({"/form", "/"})
    public String processForm(@Valid User user, BindingResult result, Model model, SessionStatus status){

        model.addAttribute("titulo","Resultado de choro");

        if(result.hasErrors()){
            /*  Mapping custom errors

            Map<String,String>  errores =  result
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(e -> e.getField() ,
                            e -> "El campo ".concat(e.getField())
                                            .concat(" ")
                                            .concat(e.getDefaultMessage())));
            model.addAttribute("error", errores);
            */
            return "index_form";
        }

        model.addAttribute("user",user);
        status.setComplete();

        return "resultado";
    }
}
