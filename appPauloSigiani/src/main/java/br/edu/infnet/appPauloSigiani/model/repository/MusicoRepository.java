package br.edu.infnet.appPauloSigiani.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appPauloSigiani.model.domain.Musico;

@Repository
public interface MusicoRepository extends CrudRepository<Musico, Integer> {
    
    Musico findByCpf(String cpf);

    Collection<Musico> findAll(Sort orderBy);
}
