package com.bolsadeideas.springboot.form.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    private Integer id;
    private String nombre;
    private String prefix;

    @Override
    public boolean equals(Object o) {

        if( this == o ) {
            return true;
        }

        if(!(o instanceof Rol)){
            return false;
        }

        Rol rol = (Rol) o;
        return this.id!=null && this.id.equals(rol.getId());
    }

}
