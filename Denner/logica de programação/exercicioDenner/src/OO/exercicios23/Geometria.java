package OO.exercicios23;

public class Geometria {
    private int num1, num2, num3, num4;
    private double n1, n2;
    private double area;

    public Geometria(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Geometria(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public Geometria(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public Geometria(int num1, int num2, int num3, int num4) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    public void retangulo(){
        System.out.println(num1 + " " + num2);
        if (num1 > 0 && num2 > 0){
            System.out.println("É retângulo");
            area = num1 * num2;
            System.out.println("Área: " + area);
        } else {
            System.out.println("Não pode fazer forma retângulo");
        }
    }

    public void triangulo(){
        System.out.println(num1 + " " + num2 + " " + num3);
        if (num1 < num2 + num3 && num2 < num1 + num3 && num3 < num1 + num2){
            System.out.println("Pode fazer forma triangulo");
            if (num1==num2 && num2==num3 && num1==num3){
                System.out.println("É triangulo equilátero");
            } else if (num1==num2 || num2==num3 || num1==num3){
                System.out.println("É triangulo isosceles");
            } else if (num1!=num2 && num2!=num3 && num1!=num3){
                System.out.println("É triangulo escaleno");
            }
        } else {
            System.out.println("Não pode fazer forma triangulo");
        }
    }

    public  void quadrado(){
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
        if (num1==num2 && num1==num3 && num1==num4 && num2==num3 && num2==num4 && num3==num4){
            System.out.println("É quadrado");
        } else {
            System.out.println("Não é quadrado");
        }
    }

    public void circulo(){
        if (n2 > 0){
            System.out.println(n1 + " " + n2);
            System.out.println("É forma circulo");
            area = n1 * (n2*n2);
            System.out.println("A area é " + area);
        } else {
            System.out.println("Não pode forma circulo");
        }
    }
}
