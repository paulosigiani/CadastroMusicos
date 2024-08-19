package br.edu.infnet.appPauloSigiani;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPauloSigiani.model.domain.Cordas;
import br.edu.infnet.appPauloSigiani.model.domain.Musico;
import br.edu.infnet.appPauloSigiani.model.domain.Sopro;
import br.edu.infnet.appPauloSigiani.model.service.MusicoService;

@Component
public class MusicoLoader implements ApplicationRunner {

    @Autowired
    MusicoService musicoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Leitura do arquivo texto
        FileReader arquivo = new FileReader("files/musico.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        //Inicializa musico
        Musico musico = null;

        while (linha != null) {

            campos = linha.split(";");

            switch (campos[0]) {
                case "M":
                    //Instancia Musico
                    musico = new Musico();
                    musico.setNome(campos[1]);
                    musico.setIdade(Integer.valueOf(campos[2]));
                    musico.setCpf(campos[3]);
                    musico.setSexo(campos[4]);
                    musico.setSalario(Float.valueOf(campos[5]));

                    musicoService.incluir(musico);

                    break;

                case "C":
                    //Instancia Cordas
                    Cordas cordas = new Cordas();
                    cordas.setNome(campos[1]);
                    cordas.setCodigo(Integer.valueOf(campos[2]));
                    cordas.setTipo(campos[3]);
                    cordas.setNumeroCordas(Integer.valueOf(campos[4]));
                    cordas.setEletrico(Boolean.valueOf(campos[5]));

                    musico.getInstrumentos().add(cordas);
                    
                    break;

                case "S":
                    //Instancia Sopro
                    Sopro sopro = new Sopro();
                    sopro.setNome(campos[1]);
                    sopro.setCodigo(Integer.valueOf(campos[2]));
                    sopro.setTipo(campos[3]);
                    sopro.setMaterial(campos[4]);
                    sopro.setAlturaTonal(campos[5]);

                    musico.getInstrumentos().add(sopro);
                            
                    break;
            
                default:
                    break;
            }
            linha = leitura.readLine();
        }
        //Imprime Musicos cadastrados
        for(Musico m : musicoService.obterLista()){
            System.out.println("Musico: " + m);
        }

        leitura.close();
    }
}