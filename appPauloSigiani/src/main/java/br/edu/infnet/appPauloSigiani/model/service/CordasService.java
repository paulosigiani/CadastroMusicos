package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;
import br.edu.infnet.appPauloSigiani.model.repository.CordasRepository;

@Service
public class CordasService {

    @Autowired
    private CordasRepository cordasRepository;

    public void incluir (Cordas cordas) {
        cordasRepository.save(cordas);
    }

    public Iterable<Cordas> obterLista () {
        return cordasRepository.findAll();       
    }

    public Iterable<Cordas> obterLista (String orderBy) {
        return cordasRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));       
    }

    public Cordas obterPorId(Integer id) {
        return cordasRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        cordasRepository.deleteById(id);
    }

    public long obterQuantidade() {
        return cordasRepository.count();
    }

    public Collection<Cordas> obterEletrico(boolean eletrico) {
        return cordasRepository.findByEletrico(eletrico);
    }
}
