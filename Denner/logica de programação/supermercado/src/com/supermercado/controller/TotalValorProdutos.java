package com.supermercado.controller;

public class TotalValorProdutos {

    private double valor;
    double acuValor = 0;


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void acumularValor(double preco, int quantidade){
        setValor(getValor() + (preco * quantidade));
        System.out.println(getValor());

    }

}
