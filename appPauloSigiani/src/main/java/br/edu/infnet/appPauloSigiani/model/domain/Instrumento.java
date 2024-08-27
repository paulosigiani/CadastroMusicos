package br.edu.infnet.appPauloSigiani.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "instrumento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrumento {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "É necessário informar o nome do instrumento.")
    private String nome;

    @Column(unique = true)
    private int codigo;

    @NotBlank(message = "É necessário informar o tipo do instrumento.")
    @Pattern(regexp = "Cordas|Sopro", message = "O tipo do instrumento deve ser \"Cordas\" ou \"Sopro\".")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_musico")
    @JsonBackReference
    private Musico musico;

    @Override
    public String toString() {
        return "id=" + id +
             ", nome=" + nome +
             ", codigo=" + codigo +
             ", tipo=" + tipo +
             ", musico=" + musico;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }
}
