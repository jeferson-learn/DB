package com.supermercado.model;

import com.supermercado.controller.Input;

import java.util.ArrayList;

public class QuantidadeProdutos {

    Input input = new Input();
    AdicionarProdutos adicionarProdutos = new AdicionarProdutos();
    Cliente cliente = new Cliente();

    public void quantidadeEstoque(ArrayList<AdicionarProdutos> listas, String opcaoSabor){
        for (AdicionarProdutos objeto : listas){
            if (objeto.getNome().equalsIgnoreCase(opcaoSabor)){
                while (true){
                    System.out.println(opcaoSabor + " tem estoque: " + objeto.getQuantidade());
                    System.out.print("Quantidade que você quer pegar: ");
                    int quantidade = input.inputInt();
                    if (quantidade <= objeto.getQuantidade() && quantidade > 0){
                        objeto.setQuantidade(objeto.getQuantidade() - quantidade);
                        cliente.clienteRecebeTotalValor(objeto.getPreco()*quantidade);//1- ok
                        System.out.println("2-Cliente: " + cliente.getTotalValor());//2- ok
                        cliente.imprimirTotalValor(); // ok
                        adicionarProdutos.guardaProdutoQuantidade(opcaoSabor, quantidade);
                        break;
                    } else {
                        System.out.println("INVALIDO");
                    }
                }

            }
        }
    }
}
