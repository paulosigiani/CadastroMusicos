package br.edu.infnet.appPauloSigiani.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;

@Repository
public interface CordasRepository extends CrudRepository<Cordas, Integer> {

    Collection<Cordas> findByEletrico(boolean eletrico);

    Collection<Cordas> findAll (Sort orderBy);
}
