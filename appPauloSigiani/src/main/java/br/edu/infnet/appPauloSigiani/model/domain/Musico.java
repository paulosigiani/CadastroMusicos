package br.edu.infnet.appPauloSigiani.model.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "musico")
public class Musico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "É necessário preencher o campo nome.")
    private String nome;

    @Positive(message = "A idade deve ser um número positivo.")
    private int idade;

    @NotBlank(message = "É preciso informar o CPF do músico.")
    @CPF
    private String cpf;

    @NotBlank(message = "É necessário informar o sexo do músico.")
    @Pattern(regexp = "F|M", message = "O campo sexo deve receber valor 'F' ou 'M'.")
    private String sexo;

    @Positive(message = "O salário deve ser um número positivo")
    @DecimalMin(value =  "1412.0", message = "O salário do músico deve ser maior que o salário mínimo: R$1.412")
    private float salario;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "id_musico")
    @JsonManagedReference
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
              ", endereço=" + endereco + 
              ", instrumentos=" + instrumentos.size();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }
}