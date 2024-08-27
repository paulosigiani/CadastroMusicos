package br.edu.infnet.appPauloSigiani.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "instrumento_de_cordas")
public class Cordas extends Instrumento {
    
    @Positive(message = "Número de cordas deve ser um número positivo")
    private int numeroCordas;

    @NotNull(message = "É preciso informar se o instrumento é elétrico ou não.")
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
