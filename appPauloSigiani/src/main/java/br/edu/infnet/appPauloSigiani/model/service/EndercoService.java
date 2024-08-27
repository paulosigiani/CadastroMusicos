package br.edu.infnet.appPauloSigiani.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPauloSigiani.client.EnderecoClient;
import br.edu.infnet.appPauloSigiani.model.domain.Endereco;

@Service
public class EndercoService {

    @Autowired
    EnderecoClient enderecoClient;

    public Endereco obterPorCep (String cep) {
        return enderecoClient.findByCep(cep);
    }
}
