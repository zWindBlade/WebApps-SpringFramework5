package com.bolsadeideas.springboot.app.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable(name = "texto") String textoString, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: ".concat(textoString));
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable(name = "texto") String textoString, @PathVariable(name = "numero") Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: "
                .concat(textoString)
                .concat(" y el numero enviado en el path es: ").concat(numero.toString()));
        return "variables/ver";
    }

}
