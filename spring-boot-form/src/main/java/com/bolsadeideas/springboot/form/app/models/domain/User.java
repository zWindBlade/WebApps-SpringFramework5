package com.bolsadeideas.springboot.form.app.models.domain;

import com.bolsadeideas.springboot.form.app.validation.annotation.IdRegex;
import com.bolsadeideas.springboot.form.app.validation.annotation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //@Pattern(regexp = "[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")
    @IdRegex
    private String id;

    //@Pattern(regexp = "^[\\S]*$")
    //@NotEmpty
    private String name;

    //@NotEmpty
    @Required
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    //@Future
    @Past
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    @NotEmpty
    private List<Rol> roles;

    private Boolean habilitar;

    @NotEmpty
    private String genero;
}
