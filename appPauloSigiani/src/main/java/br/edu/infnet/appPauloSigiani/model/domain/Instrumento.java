package br.edu.infnet.appPauloSigiani.model.domain;

public abstract class Instrumento {

    private Integer id;

    private String nome;
    private int codigo;
    private String tipo;

    @Override
    public String toString() {
        return "id=" + id +
             ", nome=" + nome +
             ", codigo=" + codigo +
             ", tipo=" + tipo;
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

}
