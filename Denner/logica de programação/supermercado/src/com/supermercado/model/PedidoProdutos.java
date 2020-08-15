package com.supermercado.model;

import com.supermercado.controller.Input;

import java.util.ArrayList;

public class PedidoProdutos {

    Input input = new Input();
    QuantidadeProdutos quantidade = new QuantidadeProdutos();

    public void opcaoSaboresBebidas(ArrayList<AdicionarProdutos> bebidas){
        boolean continuar = true;
        while (continuar) {
            System.out.println("-------------------------");
            System.out.println("[COCA] [PEPSI] [GUARANA]");
            String opcaoSabor = input.inputString();
            switch (opcaoSabor.toUpperCase()) {
                case "COCA":
                    quantidade.quantidadeEstoque(bebidas, opcaoSabor);
                    continuar = false;
                    break;
                case "PEPSI":
                    quantidade.quantidadeEstoque(bebidas, opcaoSabor);
                    continuar = false;
                    break;
                case "GUARANA":
                    quantidade.quantidadeEstoque(bebidas, opcaoSabor);
                    continuar = false;
                    break;
                default:
                    System.out.println("INVALIDO");
                    break;
            }
        }
    }

    public void opcaoSaboresComidas(ArrayList<AdicionarProdutos> comidas){
        boolean continuar = true;
        while (continuar) {
            System.out.println("-------------------------");
            System.out.println("[BOLACHA] [SALGADINHO]");
            String opcaoSabor = input.inputString();
            switch (opcaoSabor.toUpperCase()) {
                case "BOLACHA":
                    quantidade.quantidadeEstoque(comidas, opcaoSabor);
                    continuar = false;
                    break;
                case "SALGADINHO":
                    quantidade.quantidadeEstoque(comidas, opcaoSabor);
                    continuar = false;
                    break;
                default:
                    System.out.println("INVALIDO");
                    break;
            }
        }
    }

}
