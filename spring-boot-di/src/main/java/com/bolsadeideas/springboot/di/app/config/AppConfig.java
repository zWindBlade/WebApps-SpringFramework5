package com.bolsadeideas.springboot.di.app.config;

import com.bolsadeideas.springboot.di.app.model.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.model.domain.Producto;
import com.bolsadeideas.springboot.di.app.model.service.IServicio;
import com.bolsadeideas.springboot.di.app.model.service.MiServicio;
import com.bolsadeideas.springboot.di.app.model.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    public IServicio registrarmiServicioSimple(){
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    public IServicio registrarmiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony",100);
        Producto producto2 = new Producto("Bicicleta Bianchi",200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1,linea2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor Razer Panel Led 4K - Curvo",250);
        Producto producto2 = new Producto("Teclado",500);
        Producto producto3 = new Producto("Notebook Legion 7",80);
        Producto producto4 = new Producto("Escritorio Oficina Gamer con vista al mar",300);

        ItemFactura linea1 = new ItemFactura(producto1, 909999);
        ItemFactura linea2 = new ItemFactura(producto2, 1);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 1);

        return Arrays.asList(linea1,linea2,linea3,linea4);
    }


}
