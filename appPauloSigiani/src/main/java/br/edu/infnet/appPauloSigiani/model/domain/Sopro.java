package br.edu.infnet.appPauloSigiani.model.domain;

public class Sopro extends Instrumento {
    private String material;
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
