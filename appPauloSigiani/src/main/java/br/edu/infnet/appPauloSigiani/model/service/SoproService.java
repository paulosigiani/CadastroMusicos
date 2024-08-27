package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Sopro;
import br.edu.infnet.appPauloSigiani.model.repository.SoproRepository;

@Service
public class SoproService {

    @Autowired
    private SoproRepository soproRepository;

    public void incluir (Sopro sopro) {
        soproRepository.save(sopro);
    }

    public Iterable<Sopro> obterLista () {
        return soproRepository.findAll(); 
    }

    public Iterable<Sopro> obterLista (String orderBy) {
        return soproRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));       
    }

    public Sopro obterPorId(Integer id) {
        return soproRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        soproRepository.deleteById(id);
    }

    public long obterQuantidade() {
        return soproRepository.count();
    }

    public Collection<Sopro> obterPorMaterial(String material) {
        return soproRepository.findByMaterial(material);
    }
}
