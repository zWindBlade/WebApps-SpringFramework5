package com.bolsadeideas.springboot.form.app.models.domain;

import com.bolsadeideas.springboot.form.app.validation.annotation.IdRegex;
import com.bolsadeideas.springboot.form.app.validation.annotation.Required;

import javax.validation.constraints.*;

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

    public User(String id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
