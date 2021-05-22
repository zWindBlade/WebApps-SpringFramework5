package com.bolsadeideas.springboot.app.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Index");
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", defaultValue = "Default texto") String texto, Model model){
        model.addAttribute("titulo", "Recibir un parámetro del Request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: ".concat(texto));
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("titulo", "Recibir mix parámetros del Request HTTP GET - URL");
        model.addAttribute("resultado", "El saludo enviado es: '".concat(saludo).concat("' y el número es '").concat(numero.toString()).concat("'"));
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        model.addAttribute("titulo", "Recibir mix parámetros del Request HTTP GET - URL");

        String saludo = request.getParameter("saludo");
        Integer numero;

        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero=0;
        }
        model.addAttribute("resultado", "El saludo enviado es: '".concat(saludo).concat("' y el número es '").concat(numero.toString()).concat("'"));
        return "params/ver";
    }


}
