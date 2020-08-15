package teste.supermercado.view;

import teste.supermercado.controller.Input;
import teste.supermercado.controller.TotalValor;
import teste.supermercado.model.Quantidade;

public class Menu {
    Input input = new Input();
    Quantidade quantidade = new Quantidade();
    TotalValor totalValor = new TotalValor();
    boolean continuar = true;

    public void menu() {

        while (continuar) {

            System.out.println("get TOTAL: " + totalValor.getTotal());
            totalValor.setTotal(totalValor.getTotal() + 2);
            System.out.println("get TOTAL: " + totalValor.getTotal());
            System.out.println("teste: " + totalValor.getPreco().toString());

            System.out.println("-----MENU-----");
            System.out.println("[BEBIDA] [COMIDA] [SAIR]");
            String opcaoMenu = input.inputString();
            switch (opcaoMenu.toUpperCase()) {
                case "BEBIDA":
                    quantidade.bebidas();
                    break;
                case "COMIDA":

                    break;
                case "SAIR":
                    System.out.println("-------------------------");
                    continuar = false;
                    System.out.println("SAIU");
                    break;
                default:
                    System.out.println("INVALIDO");
                    break;
            }
        }
    }
}
