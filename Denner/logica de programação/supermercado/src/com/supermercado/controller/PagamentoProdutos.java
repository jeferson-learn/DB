package com.supermercado.controller;

import com.supermercado.model.Cliente;

import java.text.DecimalFormat;

public class PagamentoProdutos {

    DecimalFormat formataValor = new DecimalFormat("#,##0.00");
    boolean continuar = true;
    Cliente cliente = new Cliente();
    Input input = new Input();

    public boolean pagamento(double valor) {
        if (valor == 0) {
            System.out.println("O cliente: " + cliente.getNome());
            System.out.println("Não comprou nada, saiu no supermercado");
            return false;
        } else {
            while (continuar) {
                //Essa deve mostrar total valor que pegou produtos
                System.out.print("Total valor é: ");
                cliente.imprimirTotalValor();
                System.out.println("-------------------------");
                System.out.println("Forma de pagamento: CARTAO/CHEQUE/DINHEIRO");
                String pagamento = input.inputString();
                switch (pagamento.toUpperCase()) {
                    case "CARTAO":
                        System.out.println("Passando cartão e sucesso!");
                        return false;
                    case "CHEQUE":
                        System.out.println("Entrega cheque e sucesso!");
                        return false;
                    case "DINHEIRO":
                        System.out.print("Quantos valor que vai pagar: ");
                        double pagar = input.inputDouble();
                        if (pagar >= valor) {
                            double troco;
                            troco = pagar - valor;
                            System.out.println("Caixa está fazendo trocar o valor...");
                            System.out.println("Recebeu o troco " + formataValor.format(troco));
                            return false;
                        } else {
                            System.out.println("NÃO SUFICIENTE O VALOR");
                        }
                        break;
                    default:
                        System.out.println("INVALIDO");
                        break;
                }
            }
        }
        return true;
    }


}
