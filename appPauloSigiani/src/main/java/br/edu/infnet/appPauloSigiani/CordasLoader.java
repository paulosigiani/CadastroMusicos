package br.edu.infnet.appPauloSigiani;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;

@Component
public class CordasLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Leitura do arquivo texto
        FileReader arquivo = new FileReader("cordas.txt");
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

            linha = leitura.readLine();

            System.out.println("Instrumento de cordas: " + cordas);
        }
        leitura.close();
    }
}
