package br.edu.infnet.appPauloSigiani.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appPauloSigiani.model.domain.Sopro;
import br.edu.infnet.appPauloSigiani.model.service.SoproService;


@RestController
public class SoproController {

    @Autowired
    SoproService soproService;

    @GetMapping(value = "sopro/listar")
    public Collection<Sopro> obterLista() {
        return soproService.obterLista();
    }
    
    @GetMapping(value = "sopro/{id}")
    public Sopro obterPorId(@PathVariable Integer id) {
        return soproService.obterPorId(id);
    }

    @PostMapping("sopro/incluir")
    public String incluir(@RequestBody Sopro sopro) {
        soproService.incluir(sopro);
        return "Inclusão de " + sopro + " feita com sucesso.";
    }
    
    @DeleteMapping("sopro/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        soproService.excluir(id);
        return "Exclusão do id:" + id + " feita com sucesso." ;
    }    
}
