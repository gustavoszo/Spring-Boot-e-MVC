package com.minhapi.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.minhapi.demo.domain.Funcionario;

public interface IFuncionarioService {

    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long Id);

    Funcionario buscarPorId(Long Id);

    List<Funcionario> buscarPorTodos();

    List<Funcionario> buscarPorNome(String nome);

    List<Funcionario> buscarPorCargo(Long id);

    List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);

}