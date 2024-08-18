package br.edu.infnet.appPauloSigiani;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPauloSigiani.model.domain.Musico;

@Component
public class MusicoLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Leitura do arquivo texto
        FileReader arquivo = new FileReader("musico.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");
            //Instancia Musico
            Musico musico = new Musico();
            musico.setNome(campos[0]);
            musico.setIdade(Integer.valueOf(campos[1]));
            musico.setCpf(campos[2]);
            musico.setSexo(campos[3]);
            musico.setSalario(Float.valueOf(campos[4]));
    
            System.out.println("Musico: " + musico);

            linha = leitura.readLine();
        }
        leitura.close();
    }
}
