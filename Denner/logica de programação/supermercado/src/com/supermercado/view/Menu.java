package com.supermercado.view;

import com.supermercado.controller.Input;
import com.supermercado.controller.PagamentoProdutos;
import com.supermercado.model.*;

import java.util.ArrayList;

public class Menu {

    ArrayList<AdicionarProdutos> bebidas = new ArrayList<>();
    ArrayList<AdicionarProdutos> comidas = new ArrayList<>();
    Cliente cliente = new Cliente();
    AdicionarProdutos adicionarProdutos = new AdicionarProdutos();
    Input input = new Input();
    ImprimirProdutos imprimir = new ImprimirProdutos();
    PedidoProdutos pedido = new PedidoProdutos();
    PagamentoProdutos pagamento = new PagamentoProdutos();

    public void menu(){
        adicionarProdutos.configuracaoInicial(bebidas,comidas);
        boolean continuar = true;

        cliente.nomeCliente();
        System.out.println("O cliente: " + cliente.getNome());
        while (continuar){
            System.out.println("get TOTAL: " + cliente.getTotalValor());
            cliente.imprimirTotalValor();
            System.out.println(cliente.getNome());//sumiu depois
            System.out.println("-----MENU-----");
            System.out.println("[BEBIDA] [COMIDA] [SAIR]");
            String opcaoMenu = input.inputString();
            switch (opcaoMenu.toUpperCase()){
                case "BEBIDA":
                    imprimir.imprimeInformacoesDeProdutosNaTela(bebidas);
                    pedido.opcaoSaboresBebidas(bebidas);
                    break;
                case "COMIDA":
                    imprimir.imprimeInformacoesDeProdutosNaTela(comidas);
                    pedido.opcaoSaboresComidas(comidas);
                    break;
                case "SAIR":
                    System.out.println("-------------------------");
                    adicionarProdutos.carrinhos();
                    System.out.println("VALOR: " + cliente.getTotalValor());
                    cliente.imprimirTotalValor();
                    continuar = pagamento.pagamento(cliente.clienteRecebeTotalValorGet());
                    System.out.println("SAIU");
                    break;
                default:
                    System.out.println("INVALIDO");
                    break;
            }

        }
    }

}
