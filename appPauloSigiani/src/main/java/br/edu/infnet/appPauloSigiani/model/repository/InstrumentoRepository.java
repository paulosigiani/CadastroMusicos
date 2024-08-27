package br.edu.infnet.appPauloSigiani.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appPauloSigiani.model.domain.Instrumento;

@Repository
public interface InstrumentoRepository extends CrudRepository<Instrumento, Integer> {

    Collection<Instrumento> findByMusicoId(Integer id);
    
    Collection<Instrumento> findAll(Sort orderBy);
}
