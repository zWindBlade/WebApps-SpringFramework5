package com.bolsadeideas.springboot.app.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:titles.properties")
})
public class TextosPropertiesConfig { }
