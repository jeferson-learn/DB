package com.supermercado.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ImprimirProdutos {

    public void imprimeInformacoesDeProdutosNaTela(ArrayList<AdicionarProdutos> listaDeProdutos) {
        DecimalFormat formataValor = new DecimalFormat("#,##0.00");
        for (AdicionarProdutos object : listaDeProdutos) {
            System.out.println("-------------------------");
            System.out.println("Nome do produto: " + object.getNome());
            System.out.println("Preço do produto: " + formataValor.format(object.getPreco()));
            System.out.println("Quantidade do produto: " + object.getQuantidade());
        }
    }

}
