package OO.exercicios23;

public class Test {
    public static void main(String[] args) {
        Quadrado quadrado1 = new Quadrado(2);
        Retangulo retangulo1 = new Retangulo(3,5);
        Triangulo triangulo1 = new Triangulo(4,3);
        Circulo circulo1 = new Circulo(5);

        quadrado1.calculaArea();
        retangulo1.calculaArea();
        triangulo1.calculaArea();
        circulo1.calculaArea();

        System.out.println("A area do quadrado1 eh "+quadrado1.getArea());
        System.out.println("A area do retangulo1 eh "+retangulo1.getArea());
        System.out.println("A area do triangulo1 eh "+triangulo1.getArea());
        System.out.println("A area do circulo1 eh "+circulo1.getArea());







//        Geometria formaTriangulo = new Geometria(8,8,8);
//        formaTriangulo.triangulo();
//        System.out.println("-------------------------------");
//        Geometria formaQuadrado = new Geometria(2,2,2,2);
//        formaQuadrado.quadrado();
//        System.out.println("-------------------------------");
//        Geometria formaRetangulo = new Geometria(5,3);
//        formaRetangulo.retangulo();
//        System.out.println("-------------------------------");
//        Geometria formaCirculo = new Geometria(Math.PI, 6);
//        formaCirculo.circulo();
    }
}
