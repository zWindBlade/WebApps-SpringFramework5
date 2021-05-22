package com.bolsadeideas.springboot.di.app.model.service;

public class MiServicioComplejo implements IServicio {

    @Override
    public String operacion(){
        return "ejecutando algún proceso importante complejo...";
    }
}
