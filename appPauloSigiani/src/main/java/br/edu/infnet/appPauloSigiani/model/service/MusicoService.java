package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Musico;

@Service
public class MusicoService {

    private Map<Integer, Musico> mapa = new HashMap<Integer, Musico>();
    private Integer id = 0;

    public void incluir (Musico musico) {
        musico.setId(++id);
        mapa.put(musico.getId(), musico);
    }

    public Collection<Musico> obterLista () {
        return mapa.values();            
    }
}
