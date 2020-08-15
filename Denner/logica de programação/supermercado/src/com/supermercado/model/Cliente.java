package com.supermercado.model;

import com.supermercado.controller.Input;

public class Cliente {

    Input input = new Input();

    private String nome;
    private double totalValor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(double totalValor) {
        this.totalValor = totalValor;
    }

    public void nomeCliente(){
        System.out.print("Nome do cliente: ");
        setNome(input.inputString());
    }

    public void clienteRecebeTotalValor(double valor){
        setTotalValor(getTotalValor() + valor);
        System.out.println("1-Total: " + getTotalValor());
    }

    public double clienteRecebeTotalValorGet(){
        return getTotalValor();
    }

    public void imprimirTotalValor(){
        System.out.println(getTotalValor());
    }
}