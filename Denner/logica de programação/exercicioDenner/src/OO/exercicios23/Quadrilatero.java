package OO.exercicios23;

public class Quadrilatero {

    private int lado;
    private int base;
    private double area;

    public Quadrilatero(int lado, int base){
        this.lado = lado;
        this.base = base;
    }

    public void calculaArea(){
        setArea(getBase()*getLado());
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
