package br.edu.infnet.appPauloSigiani.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

    public String exibirMensagemAlow() {
        return "Olá, você entrou no appPauloSigiani";
    }
}
