package com.minhapi.demo.dao;

import java.util.List;

import com.minhapi.demo.domain.Departamento;

public interface IDerpatamentoDao {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
    
}
