package OO.exercicio19;

import java.util.Scanner;

public class Input {
    public static String inputString(){
        Scanner inputS = new Scanner(System.in);
        return inputS.nextLine();
    }

    public static int inputInt(){
        Scanner inputI = new Scanner(System.in);
        return inputI.nextInt();
    }
    public static double inputDouble(){
        Scanner inputI = new Scanner(System.in);
        return inputI.nextDouble();
    }
}
