package OO.exercicio19segundo;

import OO.exercicio19segundo.Modelo.Cliente;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static OO.exercicio19.Input.inputString;

public class Pedido {

    private double preco, total;
    private int quantidade;
    private Produto produt = new Produto();
    private VerificarImprimir verificarImprimir = new VerificarImprimir();

    public Pedido() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void inicial() {
        boolean opcao = true;
        Cliente cliente = new Cliente();
        Produto produto = new Produto();
        Pedido pedido = new Pedido();
        Pagamentos pagamentos = new Pagamentos();
        ArrayList<Produto> bebidas = new ArrayList<>();
        ArrayList<Produto> comidas = new ArrayList<>();

        cliente.defineCliente();
        produto.configuracaoInicial(bebidas,comidas);

        while (opcao) {
            System.out.println("-------------------------");
            System.out.println("ESCOLHE [BEBIDA] OU [COMIDA], TERMINA [SAIR]");
            String escolherOpcao = inputString();
            if (escolherOpcao.equalsIgnoreCase("sair")) {
                opcao = false;
            } else {
                String sairNaoSair = escolherTipoProduto(escolherOpcao, bebidas, comidas, pedido);
                opcao = opcaoSair(sairNaoSair);
            }
        }

//        pagamentos.pagamento(cliente, pedido, pedido.getTotal());
//        pagamentos.pagamento(cliente, pedido, pedido.getTotal(), produto);
        pagamentos.pagamento(cliente, pedido, pedido.getTotal(), bebidas, comidas);
    }

    public String escolherTipoProduto(String escolherBebidaComida, ArrayList<Produto> bebidas, ArrayList<Produto> comidas, Pedido pedido) {
        while (true) {
            if (escolherBebidaComida.equalsIgnoreCase("bebida")) {
                verificarImprimir.imprimeInformacoesDeProdutosNaTela(bebidas);
                tiposSaborBebida(bebidas, pedido);
                return escolherBebidaComida;
            } else if (escolherBebidaComida.equalsIgnoreCase("comida")) {
                verificarImprimir.imprimeInformacoesDeProdutosNaTela(comidas);
                tiposSaborComida(comidas, pedido);
                return escolherBebidaComida;
            } else if (escolherBebidaComida.equalsIgnoreCase("sair")) {
                return escolherBebidaComida;
            } else {
                System.out.println("TENTA NOVAMENTE, ESCOLHER [BEBIDA] [COMIDA] OU [SAIR]");
                escolherBebidaComida = inputString();
            }
        }
    }

    public void tiposSaborBebida(ArrayList<Produto> bebidas, Pedido pedido) {
        try {
            boolean continua = true;
            while (continua) {
                System.out.println("-------------------------");
                System.out.println("Escolhe tipo sabor");
                String escolherSaborBebida = inputString();
                switch (escolherSaborBebida) {
                    case "coca":
                        verificarImprimir.verificaEstoque(bebidas, escolherSaborBebida, pedido);
                        continua = false;
                        break;
                    case "pepsi":
                        verificarImprimir.verificaEstoque(bebidas, escolherSaborBebida, pedido);
                        continua = false;
                        break;
                    case "guarana":
                        verificarImprimir.verificaEstoque(bebidas, escolherSaborBebida, pedido);
                        continua = false;
                        break;
                    case "fim":
                        continua = false;
                        break;
                    default:
                        System.out.println("NÃO TEM OUTRO SABOR, SÓ [COCA] [PEPSI] [GUARANA]");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("NÃO DIGITE LETRA, SOMENTE NUMERO INTEIRO");
            System.out.println(e);
        }
    }

    public void tiposSaborComida(ArrayList<Produto> comidas, Pedido pedido) {
        try {
            boolean continua = true;
            while (continua) {
                System.out.println("-------------------------");
                System.out.println("Escolhe tipo sabor");
                String escolherSaborComida = inputString();
                switch (escolherSaborComida) {
                    case "bolacha":
                        verificarImprimir.verificaEstoque(comidas, escolherSaborComida, pedido);
                        continua = false;
                        break;
                    case "salgadinho":
                        verificarImprimir.verificaEstoque(comidas, escolherSaborComida, pedido);
                        continua = false;
                        break;
                    case "sair":
                        continua = false;
                        break;
                    default:
                        System.out.println("NÃO TEM OUTRO SABOR, SÓ [BOLACHA] [SALGADINHO]");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("NÃO DIGITE LETRA, SOMENTE NUMERO INTEIRO");
            System.out.println(e);
        }
    }

    public void clientePedido(ArrayList<Produto> listas, String nome, int quantidade, Pedido pedido) {
        DecimalFormat formataValor = new DecimalFormat("#,##0.00");
        for (Produto object : listas) {
            if (nome.equalsIgnoreCase(object.getNome())) {
                System.out.println("Valor: " + formataValor.format(object.getPreco() * quantidade));
                object.setQuantidade(object.getQuantidade() - quantidade);
                pedido.setTotal(pedido.getTotal() + (object.getPreco() * quantidade));

                produt.guardaProdutoQuantidade(nome, quantidade);
            }
        }
    }

    private boolean opcaoSair(String opcao) {
        if (opcao.equalsIgnoreCase("sair")) {
            return false;
        } else {
            return true;
        }
    }

}