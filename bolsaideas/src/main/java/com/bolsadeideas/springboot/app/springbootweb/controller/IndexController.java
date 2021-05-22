package com.bolsadeideas.springboot.app.springbootweb.controller;

import com.bolsadeideas.springboot.app.springbootweb.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexController.index.titulo}")
    private String tituloIndex;

    @Value("${texto.indexController.perfil.titulo}")
    private String tituloPerfil;

    @Value("${texto.indexController.listar.titulo}")
    private String tituloListar;

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", tituloIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Gabriel");
        usuario.setApellido("Rojas");
        usuario.setEmail("ga.rojasa@outlook.com");

        model.addAttribute("titulo", tituloPerfil.concat(": ").concat(usuario.getNombre()).concat(" ").concat(usuario.getApellido()));
        model.addAttribute("usuario", usuario);

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo",tituloListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public  List<Usuario> poblarUsuarios(){
        return  Arrays.asList(
                new Usuario("Gabriel", "Rojas", "ga.rojasa@outlook.com"),
                new Usuario("Jonathan", "Silva", "jo.silva@outlook.com"));
    }
}

