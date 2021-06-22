package com.bolsadeideas.springboot.form.app.services.impl;

import com.bolsadeideas.springboot.form.app.models.domain.Rol;
import com.bolsadeideas.springboot.form.app.services.RolService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private List<Rol> roles;

    public RolServiceImpl(){
        this.roles = new ArrayList<>();
        this.roles.add(Rol.builder().id(1).nombre("Administrador").prefix("ROLE_ADMIN").build());
        this.roles.add(Rol.builder().id(2).nombre("Usuario").prefix("ROLE_USER").build());
        this.roles.add(Rol.builder().id(3).nombre("Moderador").prefix("ROLE_MODERATOR").build());
    }

    @Override
    public List<Rol> list() {
        return roles;
    }

    @Override
    public Rol getById(Integer id) {
        return roles.stream().filter(rol -> rol.getId().equals(id)).findFirst().orElse(null);
    }
}
