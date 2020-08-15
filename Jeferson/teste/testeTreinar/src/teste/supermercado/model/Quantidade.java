package teste.supermercado.model;

import teste.supermercado.controller.Input;
import teste.supermercado.controller.TotalValor;

public class Quantidade {
    Input input = new Input();
    TotalValor totalValor = new TotalValor();
    Produtos produtos = new Produtos();

    public void bebidas(){
        System.out.println("1-MOSTRAR: " + totalValor.getTotal());
        System.out.println("sabor: ");
        String sabor = input.inputString();
        switch (sabor){
            case "coca":
                System.out.println("Quantidade?");
                int qts = input.inputInt();
                double valor = 5.50 * qts;
                totalValor.clienteRecebePreco(valor);
                totalValor.recebeTotal(valor);
                System.out.println("2-MOSTRAR: " + totalValor.getTotal());
                break;
            case "pepsi":

                break;
            case "guarana":

                break;
            default:
                System.out.println("INVALIDO");
        }
    }
}
