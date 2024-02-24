package com.minhapi.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minhapi.demo.dao.FuncionarioDao;
import com.minhapi.demo.domain.Funcionario;

@Transactional
@Service
public class FuncionarioService implements IFuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override 
    public void excluir(Long Id) {
        dao.delete(Id);
    }

    @Override @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long Id) {
       return dao.findById(Id);
    }

    @Override
    public List<Funcionario> buscarPorTodos() {
        return dao.findAll();
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public List<Funcionario> buscarPorCargo(Long id) {
        return dao.findByCargo(id);
    }

    @Override
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (entrada != null && saida != null) {
            return dao.findByDataEntradaSaida(entrada, saida);
        } else if (entrada != null) {
            return dao.findByDataEntrada(entrada);
        } else if (saida != null) {
            return dao.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }
    
}
