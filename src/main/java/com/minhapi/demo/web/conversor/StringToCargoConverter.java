package com.minhapi.demo.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo> {

    @Autowired
    CargoService service;

    @Override
    public Cargo convert(String text) {
       if (text.isEmpty()) {
            return null;
       }

       Long id = Long.valueOf(text);
       return service.buscarPorId(id);
    }
    
}
