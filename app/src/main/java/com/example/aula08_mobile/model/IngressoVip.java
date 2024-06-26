package com.example.aula08_mobile.model;


import androidx.annotation.NonNull;

public class IngressoVip extends Ingresso {

    private String FuncaoExercidaPelaPessoa;

    public IngressoVip() {
        super();
        this.setTaxa(0.18f);
    }

    public String getFuncaoExercidaPelaPessoa() {
        return FuncaoExercidaPelaPessoa;
    }

    public void setFuncaoExercidaPelaPessoa(String funcaoExercidaPelaPessoa) {
        FuncaoExercidaPelaPessoa = funcaoExercidaPelaPessoa;
    }

    @Override
    public float valorFinal() {
        float valorFinal = (getTaxa() * getValor()) + getValor();
        return valorFinal;
    }

    @NonNull
    @Override
    public String toString() {
        return getCodigoIdentificador() + "\n" + getValor() + "\n" + getFuncaoExercidaPelaPessoa();
    }
}
