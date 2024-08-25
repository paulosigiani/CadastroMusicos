package br.edu.infnet.appPauloSigiani.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appPauloSigiani.model.domain.Musico;
import br.edu.infnet.appPauloSigiani.model.service.MusicoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MusicoController {

    @Autowired
    MusicoService musicoService;

    @GetMapping(value = "musico/listar")
    public Collection<Musico> obterLista() {
        return musicoService.obterLista();
    }
    
    @GetMapping(value = "musico/{id}")
    public Musico obterPorId(@PathVariable Integer id) {
        return musicoService.obterPorId(id);
    }
    
    @PostMapping("musico/incluir")
    public String incluir(@RequestBody Musico musico) {
        musicoService.incluir(musico);
        return "Inclusão de " + musico + " feita com sucesso.";
    }

    @DeleteMapping("musico/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        musicoService.excluir(id);
        return "Exclusão do id:" + id + " feita com sucesso." ;
    }    
}
