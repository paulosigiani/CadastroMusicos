package br.edu.infnet.appPauloSigiani.model.domain;

public class Cordas extends Instrumento {
    private int numeroCordas;
    private boolean eletrico;

    @Override
    public String toString() {
        return "[" + super.toString() 
                   + ", numeroCordas=" + numeroCordas 
                   + ", eletrico=" + (eletrico ? "sim" : "não")  + "]";
    }

    public int getNumeroCordas() {
        return numeroCordas;
    }

    public void setNumeroCordas(int numeroCordas) {
        this.numeroCordas = numeroCordas;
    }

    public boolean isEletrico() {
        return eletrico;
    }

    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
    }

}
