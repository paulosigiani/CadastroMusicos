package br.edu.infnet.appPauloSigiani;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPauloSigiani.model.domain.Sopro;

@Component
public class SoproLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Leitura do arquivo texto
        FileReader arquivo = new FileReader("sopro.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");
            //Instancia sopro
            Sopro sopro = new Sopro();
            sopro.setNome(campos[0]);
            sopro.setCodigo(Integer.valueOf(campos[1]));
            sopro.setTipo(campos[2]);
            sopro.setMaterial(campos[3]);
            sopro.setAlturaTonal(campos[4]);

            linha = leitura.readLine();

            System.out.println("Instrumento de sopro: " + sopro);
        }
        leitura.close();
    }
}
