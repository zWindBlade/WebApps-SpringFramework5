package com.bolsadeideas.springboot.form.app.services.impl;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    private List<Pais> list;

    public PaisServiceImpl(){
        this.list = Arrays.asList(
                Pais.builder().id(1).codigo("ES").nombre("España").build(),
                Pais.builder().id(2).codigo("MX").nombre("Mexico").build(),
                Pais.builder().id(3).codigo("CL").nombre("Chile").build(),
                Pais.builder().id(4).codigo("AR").nombre("Argentina").build(),
                Pais.builder().id(5).codigo("PE").nombre("Perú").build()
        );
    }

    @Override
    public List<Pais> list() {
        return list;
    }

    @Override
    public Pais getById(Integer id) {
            return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
