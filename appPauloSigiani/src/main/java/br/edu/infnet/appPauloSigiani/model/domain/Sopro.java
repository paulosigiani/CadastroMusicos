package br.edu.infnet.appPauloSigiani.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "instrumento_de_sopro")
public class Sopro extends Instrumento {
    
    @NotBlank(message = "É necessário informar o material do instrumento.")
    private String material;

    @NotBlank(message = "É necessário informar a altura tonal do instrumento.")
    private String alturaTonal;

    @Override
    public String toString() {
        return "[" + super.toString() 
                   + ", material=" + material 
                   + ", alturaTonal=" + alturaTonal + "]";
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAlturaTonal() {
        return alturaTonal;
    }

    public void setAlturaTonal(String alturaTonal) {
        this.alturaTonal = alturaTonal;
    }
}
