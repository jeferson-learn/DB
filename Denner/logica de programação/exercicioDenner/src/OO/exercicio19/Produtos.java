package OO.exercicio19;

import static OO.exercicio19.Estoque.*;

public class Produtos {

    private static boolean boo,boo1;
    static int x;

    public Produtos() {
    }

    public static void bebidas(){
        boo = boo1 = true;
        while (boo){
            System.out.println("COCA 2 Litros: 5,50 (tem " + getCocaCola() + " estoque)");
            System.out.println("PEPSI 2 Litros: 5,00 (tem " + getPepsi() + " estoque)");
            System.out.println("GUARANA 2 Litros: 4,50 (tem " + getGuarana() + " estoque)");
            System.out.println("--------------------------------");
            System.out.print("Qual você quer: ");
            String tipos = Input.inputString().toUpperCase();
            switch (tipos){
                case "COCA":
                    System.out.println("--------------------------------");
                    while(boo1) {
                        System.out.print("Quantidade você quer: ");
                        x = Input.inputInt();
                        if (x <= getCocaCola() && x > 0) {
                            Estoque.bebida(tipos, x);
                            Cliente.total(5.5 * x);
                            boo = boo1 = false;
                        } else {
                            System.out.println("Não existe estoque, tenta novamente");
                            System.out.println("--------------------------------");
                            boo1 = false;
                        }
                    }
                    break;
                case "PEPSI":
                    System.out.println("--------------------------------");
                    while(boo1) {
                        System.out.print("Quantidade você quer: ");
                        x = Input.inputInt();
                        if (x <= getPepsi() && x > 0) {
                            Estoque.bebida(tipos, x);
                            Cliente.total(5.0 * x);
                            boo = boo1 = false;
                        } else {
                            System.out.println("Não existe estoque, tenta novamente");
                            System.out.println("--------------------------------");
                            boo1 = false;
                        }
                    }
                    break;
                case "GUARANA":
                    System.out.println("--------------------------------");
                    while(boo1) {
                        System.out.print("Quantidade você quer: ");
                        x = Input.inputInt();
                        if (x <= getGuarana() && x > 0) {
                            Estoque.bebida(tipos, x);
                            Cliente.total(4.5 * x);
                            boo = boo1 = false;
                        } else {
                            System.out.println("Não existe estoque, tenta novamente");
                            System.out.println("--------------------------------");
                            boo1 = false;
                        }
                    }
                    break;
                default:
                    System.out.println("Não temos outro tipos de bebidas");
            }
        }
    }

    public static void comidas(){
        boo = boo1 = true;
        while (boo){
            System.out.println("-> Bolacha: 2,50 (tem " + getBolacha() + " estoque)");
            System.out.println("-> Salgadinho: 4,00 (tem " + getSalgadinho() + " estoque)");
            System.out.println("--------------------------------");
            System.out.print("Qual você quer: ");
            String tipos = Input.inputString().toUpperCase();
            switch (tipos){
                case "BOLACHA":
                    System.out.println("--------------------------------");
                    while(boo1) {
                        System.out.print("Quantidade você quer: ");
                        x = Input.inputInt();
                        if (x <= getBolacha() && x > 0) {
                            Estoque.comidas(tipos, x);
                            Cliente.total(2.5 * x);
                            boo = boo1 = false;
                        } else {
                            System.out.println("Não existe estoque, tenta novamente");
                            System.out.println("--------------------------------");
                            boo1 = false;
                        }
                    }
                    break;
                case "SALGADINHO":
                    System.out.println("--------------------------------");
                    while(boo1) {
                        System.out.print("Quantidade você quer: ");
                        x = Input.inputInt();
                        if (x <= getSalgadinho() && x > 0) {
                            Estoque.comidas(tipos, x);
                            Cliente.total(4.0 * x);
                            boo = boo1 = false;
                        } else {
                            System.out.println("Não existe estoque, tenta novamente");
                            System.out.println("--------------------------------");
                            boo1 = false;
                        }
                    }
                    break;
                default:
                    System.out.println("Não temos outro tipos de comidas");

            }
        }
    }
}
