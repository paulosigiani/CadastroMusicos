package br.edu.infnet.appPauloSigiani.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;

@Service
public class CordasService {

    private Map<Integer, Cordas> mapa = new HashMap<Integer, Cordas>();
    private Integer id = 0;

    public void incluir (Cordas cordas) {
        cordas.setId(++id);
        mapa.put(cordas.getId(), cordas);
    }

    public Collection<Cordas> obterLista () {
        return mapa.values();            
    }

    public Cordas obterPorId(Integer id) {
        return mapa.get(id);
    }

    public void excluir(Integer id) {
        mapa.remove(id);
    }

    public int obterQuantidade() {
        return mapa.size();
    }
}
