package br.edu.infnet.appPauloSigiani.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appPauloSigiani.model.domain.Sopro;

@Repository
public interface SoproRepository extends CrudRepository<Sopro, Integer> {

    Collection<Sopro> findByMaterial(String material);

    Collection<Sopro> findAll(Sort orderBy);
}
