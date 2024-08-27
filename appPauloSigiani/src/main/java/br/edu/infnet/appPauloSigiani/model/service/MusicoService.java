package br.edu.infnet.appPauloSigiani.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Musico;
import br.edu.infnet.appPauloSigiani.model.repository.MusicoRepository;

@Service
public class MusicoService {

    @Autowired
    private MusicoRepository musicoRepository;

    public void incluir (Musico musico) {
        musicoRepository.save(musico);
    }

    public Iterable<Musico> obterLista () {
        return musicoRepository.findAll();           
    }

    public Iterable<Musico> obterLista (String orderBy) {
        return musicoRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));       
    }

    public Musico obterPorId(Integer id) {
        return musicoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        musicoRepository.deleteById(id);
    }

    public long obterQuantidade() {
        return musicoRepository.count();
    }

    public Musico obterPorCpf(String cpf) {
        return musicoRepository.findByCpf(cpf);
    }
}
