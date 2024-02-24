package com.minhapi.demo.service;

import java.util.List;

import com.minhapi.demo.domain.Departamento;

public interface IDepartamentoService {

    void salvar(Departamento departamento);

    void editar(Departamento departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarPorTodos();

    boolean departamentoTemCargos(Long id);
    
}