package br.edu.infnet.appPauloSigiani;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;
import br.edu.infnet.appPauloSigiani.model.service.CordasService;

@Component
public class CordasLoader implements ApplicationRunner {

    @Autowired
    private CordasService cordasService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Leitura do arquivo texto
        FileReader arquivo = new FileReader("files/cordas.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");
            //Instancia Cordas
            Cordas cordas = new Cordas();
            cordas.setNome(campos[0]);
            cordas.setCodigo(Integer.valueOf(campos[1]));
            cordas.setTipo(campos[2]);
            cordas.setNumeroCordas(Integer.valueOf(campos[3]));
            cordas.setEletrico(Boolean.valueOf(campos[4]));

            cordasService.incluir(cordas);

            linha = leitura.readLine();
        }
        for(Cordas c : cordasService.obterLista()) {
            System.out.println("Instrumento de cordas: " + c);
        }

        leitura.close();
    }
}
