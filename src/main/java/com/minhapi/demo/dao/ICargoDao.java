package com.minhapi.demo.dao;

import java.util.List;

import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.util.PaginacaoUtil;

public interface ICargoDao {
    
    void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

    PaginacaoUtil<Cargo> buscaPaginada(int pagina, String dir);

}
