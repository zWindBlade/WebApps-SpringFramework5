package com.bolsadeideas.springboot.form.app.controllers;

import com.bolsadeideas.springboot.form.app.editors.NameUpperCaseEditor;
import com.bolsadeideas.springboot.form.app.editors.PaisPropertyEditor;
import com.bolsadeideas.springboot.form.app.editors.RolPropertyEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Rol;
import com.bolsadeideas.springboot.form.app.models.domain.User;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.services.RolService;
import com.bolsadeideas.springboot.form.app.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PaisService paisService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @Autowired
    private RolPropertyEditor rolPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        webDataBinder.addValidators(userValidator);
        webDataBinder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(simpleDateFormat, true));
        webDataBinder.registerCustomEditor(String.class, "name", new NameUpperCaseEditor());
        webDataBinder.registerCustomEditor(String.class, "lastname", new NameUpperCaseEditor());
        webDataBinder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);
        webDataBinder.registerCustomEditor(Rol.class, "roles", rolPropertyEditor);
    }

    /*
    @ModelAttribute("paises")
    public List<String> paises (){
        return Arrays.asList("España","Mexico","Chile","Argentina","Perú");
    }

    @ModelAttribute("paises")
    public Map<String,String> paises (){
        Map<String,String> paises = new HashMap<String,String>(){{
            put("ES", "España");
            put("MX", "Mexico");
            put("CL", "Chile");
            put("AR", "Argentina");
            put("PE", "Perú");
            put("CO", "Colombia");
            put("VE", "Venezuela");
        }};
        return paises;
    }

    @ModelAttribute("paises")
    public List<Pais> paises() {
        return Arrays.asList(
                Pais.builder().id(1).codigo("ES").nombre("España").build(),
                Pais.builder().id(2).codigo("MX").nombre("Mexico").build(),
                Pais.builder().id(3).codigo("CL").nombre("Chile").build(),
                Pais.builder().id(4).codigo("AR").nombre("Argentina").build(),
                Pais.builder().id(5).codigo("PE").nombre("Perú").build()
        );
    }
     */

    @ModelAttribute("generos")
    public List<String> generos (){
        return Arrays.asList("Hombre","Mujer","Unisex");
    }

    @ModelAttribute("paises")
    public List<Pais> paises() {
        return paisService.list();
    }

    @ModelAttribute("roles")
    public List<Rol> roles() {
       return rolService.list();
    }

    @GetMapping({"/form", "/"})
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario de choro");
        model.addAttribute("user", User.builder().id("12.456.789-K")
                .name("Jhon").lastname("Doe")
                .fechaNacimiento(new Date()).password("theshoro").cuenta(5)
                .email("jejejeje@hotmail.es").username("elshoro").habilitar(true)
                .pais(Pais.builder().id(3).codigo("CL").nombre("Chile").build())
                .roles(Arrays.asList(Rol.builder().id(2).nombre("Usuario").prefix("ROLE_USER").build()))
                .build());
        return "index_form";
    }

    @PostMapping({"/form", "/"})
    public String processForm(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
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
            model.addAttribute("titulo", "Resultado de choro");
            return "index_form";
        }

        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String redirect(@SessionAttribute( name = "usuario", required = false) User user, Model model, SessionStatus status) {

        if(user == null){
            return "redirect:/form";
        }

        model.addAttribute("titulo", "Resultado de choro");
        status.setComplete();

        return "resultado";
    }

}
