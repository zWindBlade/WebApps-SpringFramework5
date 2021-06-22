package com.bolsadeideas.springboot.form.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    private Integer id;

    private String codigo;

    private String nombre;

    @Override
    public String toString() {
        return this.id.toString();
    }
}