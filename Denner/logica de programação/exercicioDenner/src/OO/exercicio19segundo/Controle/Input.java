package OO.exercicio19segundo.Controle;

import java.util.Scanner;

public class Input {
    private String inputString() {
        Scanner inputS = new Scanner(System.in);
        return inputS.nextLine();
    }

    public int inputInt() {
        Scanner inputI = new Scanner(System.in);
        return inputI.nextInt();
    }

    public double inputDouble() {
        Scanner inputD = new Scanner(System.in);
        return inputD.nextDouble();
    }
}
