package com.bolsadeideas.springboot.form.app.editors;

import com.bolsadeideas.springboot.form.app.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private RolService rolService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
       try {
           Integer id = Integer.parseInt(text);
           this.setValue(rolService.getById(id));
       }catch ( NumberFormatException e){
           this.setValue(null);
       }
    }
}
