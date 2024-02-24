package com.minhapi.demo.service;

import java.util.List;

import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.util.PaginacaoUtil;

public interface ICargoService {

    void salvar(Cargo cargo);

    void editar(Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarPorTodos();

    boolean cargoTemFuncionario(Long id);

    PaginacaoUtil<Cargo> buscaPorPagina(int pagina, String dir);
    
}