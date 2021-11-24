package br.org.fe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.fe.LojaModel;


@Repository
public interface LojaRepository extends JpaRepository<LojaModel, Long> {
	
	public List<LojaModel> findAllByProdutoContainingIgnoreCase (String produto);

}
