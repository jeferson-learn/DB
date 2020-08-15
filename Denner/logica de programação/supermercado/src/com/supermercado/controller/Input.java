package com.supermercado.controller;

import java.util.Scanner;

public class Input {

    public String inputString() {
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
