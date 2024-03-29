package com.minhapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minhapi.demo.dao.CargoDao;
import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.util.PaginacaoUtil;

@Service @Transactional
public class CargoService implements ICargoService {

    @Autowired
    private CargoDao dao;

    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    public void excluir(Long id) {
       dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarPorTodos() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionario(Long id) {
       if ( buscarPorId(id).getFuncionarios().isEmpty() ) {
            return false;
       }

       return true;
    }

    @Override
    public PaginacaoUtil<Cargo> buscaPorPagina(int pagina, String dir) {
        return dao.buscaPaginada(pagina, dir);
    }
    

}
