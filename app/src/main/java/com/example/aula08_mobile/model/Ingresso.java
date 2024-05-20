package com.example.aula08_mobile.model;

public class Ingresso {

    private String codigoIdentificador;
    private float valor;
    private float taxa;
    public Ingresso(){
        super();
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float valorFinal(){
        float taxa = this.valor * this.taxa;
        float valorFinal = this.valor + taxa;
        return valorFinal;
    }
}
