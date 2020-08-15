package OO.exercicios23;

public class Circulo {

    private int raio;
    private double area;

    public Circulo(int raio) {
        this.raio = raio;
    }

    public void calculaArea(){
        setArea(getRaio()*getRaio()*3.14);
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
