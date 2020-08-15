package bola;

public class Main {
    public static void main(String[] args) {

        Bola bolaRed = new Bola("Vermelho", 10, 50, 20);
        Brinquedo boneca = new Brinquedo();

        System.out.println("A bola cor é: " + bolaRed.getCor());
        bolaRed.setCor("Azul");
        System.out.println("A bola agora cor é: " + bolaRed.getCor());

        bolaRed.quicar();

        boneca.brincar();
        boneca.setPreco(20);
        System.out.println("boneca Valor é: " + boneca.getPreco());

        bolaRed.setPreco(50);
        System.out.println("A bola valor é: " + bolaRed.getPreco());



    }
}
