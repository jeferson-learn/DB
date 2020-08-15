package OO.exercicio19segundo;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static OO.exercicio19.Input.inputInt;

public class VerificarImprimir {

    private Produto produt = new Produto();
    private String produto[] = new String[5];
    private int itens[] = new int[5];

    public void imprimeInformacoesDeProdutosNaTela(ArrayList<Produto> listaDeProdutos) {
        DecimalFormat formataValor = new DecimalFormat("#,##0.00");
        for (Produto object : listaDeProdutos) {
            System.out.println("-------------------------");
            System.out.println("Nome do produto: " + object.getNome());
            System.out.println("preço do produto: " + formataValor.format(object.getPreco()));
            System.out.println("Quantidade do produto: " + object.getQuantidade());
        }
    }

    public void imprimirProdutoQuantidade(ArrayList<Produto> bebidas, ArrayList<Produto> comidas) {
        System.out.println("imprimir Prod");

        for(Produto produto : bebidas) {
            System.out.println(produto.getQuantidade());
        }

//        produt.array();

//        for (int i = 0; i < produto.length; i++) {
//            if (produto[i] != null) {
//                System.out.println("teste dentro");
//                System.out.println(produto[i] + ": " + itens[i]);
//            }
//        }
    }

    public void verificaEstoque(ArrayList<Produto> listas, String escolherSaborBebida, Pedido pedido) {
        System.out.print("Quantidade que você quer pegar: ");
        int quantidade = inputInt();
        int estoque = verificaSeTemEstoqueDeUmProdutoPeloNome(escolherSaborBebida, listas);
        if (estoque == 0) {
            System.out.println("NÃO TEM MAIS ESTOQUE");
        } else if (quantidade <= estoque && quantidade > 0) {
            pedido.clientePedido(listas, escolherSaborBebida, quantidade, pedido);
        } else {
            System.out.println("NÃO EXISTE ESTOQUE");
        }
    }

    public int verificaSeTemEstoqueDeUmProdutoPeloNome(String nome, ArrayList<Produto> listas) {
        for (Produto produto : listas) {
            if (nome.equalsIgnoreCase(produto.getNome())) {
                System.out.println("-------------------------");
                return produto.getQuantidade();
            }
        }
        return -1;
    }

}
