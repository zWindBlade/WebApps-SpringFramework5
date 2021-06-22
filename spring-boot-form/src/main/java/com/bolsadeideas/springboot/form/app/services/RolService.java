package com.bolsadeideas.springboot.form.app.services;

import com.bolsadeideas.springboot.form.app.models.domain.Rol;

import java.util.List;

public interface RolService {

    List<Rol> list();
    Rol getById (Integer id);
}
