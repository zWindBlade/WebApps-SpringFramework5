package com.bolsadeideas.springboot.form.app.services;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> list();
    Pais getById(Integer id);
}
