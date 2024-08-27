package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Instrumento;
import br.edu.infnet.appPauloSigiani.model.domain.Musico;
import br.edu.infnet.appPauloSigiani.model.repository.InstrumentoRepository;

@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository instrumentoRepository;
/* 
    public void incluir (Instrumento instrumento) {
        InstrumentoRepository.save(instrumento);
    }
*/
    public Iterable<Instrumento> obterLista () {
        return instrumentoRepository.findAll();       
    }

    public Iterable<Instrumento> obterLista (String orderBy) {
        return instrumentoRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));       
    }

    public Instrumento obterPorId(Integer id) {
        return instrumentoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        instrumentoRepository.deleteById(id);
    }

    public long obterQuantidade() {
        return instrumentoRepository.count();
    }

    public Collection<Instrumento> obterPorMusicoId(Integer id) {
        return instrumentoRepository.findByMusicoId(id);
    }

    public Collection<Instrumento> obterPorMusicoId(Musico musico) {
        return instrumentoRepository.findByMusicoId(musico.getId());
    }
}
