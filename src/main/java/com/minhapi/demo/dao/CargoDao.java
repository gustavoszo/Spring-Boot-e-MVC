package com.minhapi.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.util.PaginacaoUtil;

@Repository
public class CargoDao extends AbstractDao<Cargo, Long> implements ICargoDao {

	public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao) {
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho;
		List<Cargo> cargos = getEntityManager()
				.createQuery("select c from Cargo c order by c.nome " + direcao, Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, cargos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Cargo", Long.class)
				.getSingleResult();
	}
}
