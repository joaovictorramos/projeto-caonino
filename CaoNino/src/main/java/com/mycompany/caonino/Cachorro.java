package com.mycompany.caonino2;

public class Cachorro {
    private String nomeCachorro;
    private String dataCachorro;
    private String raca;
    private String cor;
    private double peso;
    
    public Cachorro(String nomeCachorro, String dataCachorro, String raca, String cor, double peso){
        setNomeCachorro(nomeCachorro);
        setDataCachorro(dataCachorro);
        setRaca(raca);
        setCor(cor);
        setPeso(peso);
    }

    public String getNomeCachorro() {
        return nomeCachorro;
    }

    public void setNomeCachorro(String nomeCachorro) {
        this.nomeCachorro = nomeCachorro;
    }

    public String getDataCachorro() {
        return dataCachorro;
    }

    public void setDataCachorro(String dataCachorro) {
        this.dataCachorro = dataCachorro;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
