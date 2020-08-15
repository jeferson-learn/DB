package OO.exercicio19;

import static OO.exercicio19.Input.inputDouble;
import static OO.exercicio19.Input.inputString;

public class SupermercadoTest {

    public static void main(String[] args) throws InterruptedException {

        boolean loop = true,loop1 = true;
        Cliente cliente = new Cliente();

        System.out.println("Bem vindo SUPERMERCADO");
        System.out.println("--------------------------------");
        System.out.print("O nome do CLIENTE: ");
        cliente.setNome(inputString());
        System.out.println("O cliente " + cliente.getNome() + " entrando o supermercado.");
        while (loop1){
            while (loop){
                System.out.println("--------------------------------");
                System.out.println("Temos os produtos no supermercado");
                System.out.println("-> BEBIDA");
                System.out.println("-> COMIDA");
                System.out.println("O que você quer comprar? Se não, escreve 'SAIR'");
                String produto = inputString().toUpperCase();
                System.out.println("--------------------------------");
                switch (produto){
                    case "BEBIDA":
                        Produtos.bebidas();
                        break;
                    case "COMIDA":
                        Produtos.comidas();
                        break;
                    case "SAIR":
                        loop = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Não encontrado");
                }
            }
            System.out.println("--------------------------------");
            System.out.println(Cliente.getNome() + " tem o que paga valor " + Cliente.getValor());
            if (Cliente.getValor()!=0){
                System.out.println("--------------------------------");
                System.out.println("Forma de pagamento:");
                System.out.println("CARTAO/DINHEIRO/CHEQUE:");
                String pagamento = Input.inputString().toUpperCase();
                switch (pagamento){
                    case "CARTAO":
                        System.out.println("--------------------------------");
                        System.out.println("O cliente escolheu cartão de pagamento");
                        System.out.println("Passando cartão");
                        Thread.sleep(2000);
                        System.out.println("O cliente faz senha");
                        Thread.sleep(2000);
                        System.out.println("...");
                        Thread.sleep(2000);
                        System.out.println("...");
                        Thread.sleep(2000);
                        System.out.println("Sucesso");
                        System.out.println("Saiu no supermercado...");
                        loop1 = false;
                        break;
                    case "DINHEIRO":
                        System.out.println("--------------------------------");
                        boolean boo=true;
                        double pagar, trocar;
                        while (boo){
                            System.out.print(Cliente.getNome() + " vai pagar o valor: ");
                            pagar = inputDouble();
                            if (pagar>=Cliente.getValor()){
                                System.out.println("Caixa está fazendo trocar o valor...");
                                Thread.sleep(2000);
                                trocar = pagar - Cliente.getValor();
                                System.out.println(Cliente.getNome() + " recebeu o troco " + trocar);
                                System.out.println("Saiu no supermercado...");
                                boo = false;
                            } else {
                                System.out.println("Não suficiente o valor para pagar");
                            }
                        }
                        loop1 = false;
                        break;
                    case "CHEQUE":
                        System.out.println("--------------------------------");
                        System.out.println("O cliente escolheu cheque de pagamento");
                        System.out.println("O cliente pegou cheque");
                        Thread.sleep(2000);
                        System.out.println("O cliente faz preencher");
                        Thread.sleep(2000);
                        System.out.println("...");
                        Thread.sleep(2000);
                        System.out.println("Entregou e pronto");
                        Thread.sleep(2000);
                        System.out.println("Saiu no supermercado...");
                        loop1 = false;
                        break;
                    default:
                        System.out.println("Não temos outro opção.");
                }
            } else {
                loop1 = false;
                System.out.println("Não foi comprar alguma coisa.");
                System.out.println("Saiu no supermercado...");
            }
        }
    }
}
