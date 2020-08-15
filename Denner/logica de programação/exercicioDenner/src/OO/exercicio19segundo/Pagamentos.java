package OO.exercicio19segundo;

import OO.exercicio19segundo.Modelo.Cliente;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static OO.exercicio19.Input.inputDouble;
import static OO.exercicio19.Input.inputString;

public class Pagamentos {

    DecimalFormat formataValor = new DecimalFormat("#,##0.00");
    VerificarImprimir verificarImprimir = new VerificarImprimir();
    Produto produto = new Produto();
    ArrayList<Produto> listas = new ArrayList<>();
    boolean opcaoPagamento = true;


    public void pagamento(Cliente cliente, Pedido pedido, double valor, ArrayList<Produto> bebidas, ArrayList<Produto> comidas) {

        if (valor == 0) {
            System.out.println("Não comprou nada, saiu no supermercado");
            opcaoPagamento = false;
        }

        while (opcaoPagamento) {
            System.out.println("-------------------------");
            System.out.println("Quantidade do produto:");
            verificarImprimir.imprimirProdutoQuantidade(bebidas,comidas);
            produto.array();
            System.out.println(cliente.getNome() + " tem que pagar total é: " + formataValor.format(pedido.getTotal()));
            System.out.println("-------------------------");
            System.out.println("Forma de pagamento: CARTAO/CHEQUE/DINHEIRO");
            String pagamento = inputString();

            switch (pagamento.toUpperCase()) {
                case "CARTAO":
                    System.out.println("Passando cartão e sucesso!");
                    System.out.println("Saiu no supermercado...");
                    opcaoPagamento = false;
                    break;
                case "CHEQUE":
                    System.out.println(cliente.getNome() + " faz preencher, entrega e pronto");
                    System.out.println("Saiu no supermercado...");
                    opcaoPagamento = false;
                    break;
                case "DINHEIRO":
                    System.out.print(cliente.getNome() + " vai pagar o valor: ");
                    double pagar = inputDouble();
                    if (pagar >= valor) {
                        double troco;
                        troco = pagar - valor;
                        System.out.println("Caixa está fazendo trocar o valor...");
                        System.out.println(cliente.getNome() + " recebeu o troco " + formataValor.format(troco));
                        System.out.println("Saiu no supermercado...");
                        opcaoPagamento = false;
                    } else {
                        System.out.println("NÃO SUFICIENTE O VALOR");
                    }
                    break;
                default:
                    System.out.println("-------------------------");
                    System.out.println("NÃO TEM OUTRO OPÇÃO DE PAGAMENTO");
                    break;
            }
        }
    }
}
