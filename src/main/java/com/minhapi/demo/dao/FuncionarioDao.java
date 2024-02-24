package com.minhapi.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.minhapi.demo.domain.Funcionario;

@Repository
public class FuncionarioDao extends AbstractDao<Funcionario, Long> implements IFuncionarioDao {

    @Override
    public List<Funcionario> findByNome(String nome) {
        return createQuery("select f from Funcionario f where f.nome like concat('%', ?1, '%')", nome);
    }

    @Override
    public List<Funcionario> findByCargo(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }

    @Override
    public List<Funcionario> findByDataEntrada(LocalDate entrada) {
        return createQuery("select f from Funcionario f where f.dataEntrada >= ?1", entrada);
    }

    @Override
    public List<Funcionario> findByDataSaida(LocalDate saida) {
        return createQuery("select f from Funcionario f where f.dataSaida <= ?1", saida);
    }

    @Override
    public List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida) {
        String jpql = "select f from Funcionario f where f.dataEntrada >= ?1" +
                    "and f.dataSaida <= ?2" +
                    "order by f.dataEntrada";
        return createQuery(jpql, entrada, saida);

    }

    
}