package br.edu.infnet.appPauloSigiani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appPauloSigiani.model.service.CordasService;
import br.edu.infnet.appPauloSigiani.model.service.InstrumentoService;
import br.edu.infnet.appPauloSigiani.model.service.MusicoService;
import br.edu.infnet.appPauloSigiani.model.service.SoproService;



@Controller
public class AppController {

    @Autowired
    private MusicoService musicoService;

    @Autowired
    private InstrumentoService instrumentoService;

    @Autowired
    private CordasService cordasService;

    @Autowired
    private SoproService soproService;

    @GetMapping(value = "/")
    public String telaHome(Model model) {

        model.addAttribute("qtdeMusico", musicoService.obterQuantidade());
        model.addAttribute("qtdeInstrumento", instrumentoService.obterQuantidade());
        model.addAttribute("qtdeCordas", cordasService.obterQuantidade());
        model.addAttribute("qtdeSopro", soproService.obterQuantidade());

        return "home";
    }
    
}
