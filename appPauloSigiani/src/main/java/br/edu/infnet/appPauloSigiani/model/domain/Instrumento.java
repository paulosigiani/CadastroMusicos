package br.edu.infnet.appPauloSigiani.model.domain;

public abstract class Instrumento {
    private String nome;
    private int codigo;
    private String tipo;

    @Override
    public String toString() {
        return "nome=" + nome + ", " +
               "codigo=" + codigo + ", " +
               "tipo=" + tipo;
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
