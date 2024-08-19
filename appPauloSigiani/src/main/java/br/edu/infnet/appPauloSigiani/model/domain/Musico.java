package br.edu.infnet.appPauloSigiani.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Musico {

    private Integer id;

    private String nome;
    private int idade;
    private String cpf;
    private String sexo;
    private float salario;

    private List<Instrumento> instrumentos;

    public Musico() {
        instrumentos = new ArrayList<Instrumento>();
    }

    @Override
    public String toString() {
        return "[id=" + id+
              ", nome=" + nome + 
              ", idade=" + idade + 
              ", cpf=" + cpf + ", sexo=" + sexo + 
              ", salario=" + salario + 
              ", instrumentos=" + instrumentos.size() + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }
}