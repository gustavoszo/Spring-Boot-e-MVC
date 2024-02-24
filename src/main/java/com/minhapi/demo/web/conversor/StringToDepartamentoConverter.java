package com.minhapi.demo.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.minhapi.demo.domain.Departamento;
import com.minhapi.demo.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

    @Autowired
    DepartamentoService service;

    @Override
    public Departamento convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long Id = Long.valueOf(text);
        return service.buscarPorId(Id);
        
    }
    
}
