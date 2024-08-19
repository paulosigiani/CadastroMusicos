package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Sopro;

@Service
public class SoproService {

    private Map<Integer, Sopro> mapa = new HashMap<Integer, Sopro>();
    private Integer id = 0;

    public void incluir (Sopro sopro) {
        sopro.setId(++id);
        mapa.put(sopro.getId(), sopro);
    }

    public Collection<Sopro> obterLista () {
        return mapa.values();            
    }
}
