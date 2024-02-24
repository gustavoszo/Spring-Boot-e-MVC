package com.minhapi.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.minhapi.demo.domain.Funcionario;

public interface IFuncionarioDao {

    void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll(); 

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargo(Long id);

    List<Funcionario> findByDataEntrada(LocalDate entrada);

    List<Funcionario> findByDataSaida(LocalDate saida);

    List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida);

} 
    
