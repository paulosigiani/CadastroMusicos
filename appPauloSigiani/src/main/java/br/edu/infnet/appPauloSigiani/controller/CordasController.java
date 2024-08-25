package br.edu.infnet.appPauloSigiani.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;
import br.edu.infnet.appPauloSigiani.model.service.CordasService;


@RestController
public class CordasController {

    @Autowired
    CordasService cordasService;

    @GetMapping(value = "cordas/listar")
    public Collection<Cordas> obterLista() {
        return cordasService.obterLista();
    }
    
    @GetMapping(value = "cordas/{id}")
    public Cordas obterPorId(@PathVariable Integer id) {
        return cordasService.obterPorId(id);
    }

    @PostMapping("cordas/incluir")
    public String incluir(@RequestBody Cordas cordas) {
        cordasService.incluir(cordas);
        return "Inclusão de " + cordas + " feita com sucesso.";
    }

    @DeleteMapping("cordas/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        cordasService.excluir(id);
        return "Exclusão do id:" + id + " feita com sucesso." ;
    }    
}
