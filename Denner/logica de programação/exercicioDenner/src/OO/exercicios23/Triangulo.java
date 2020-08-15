package OO.exercicios23;

public class Triangulo extends Quadrilatero {

    public Triangulo(int lado, int base) {
        super(lado, base);
    }

    @Override
    public void calculaArea(){
        setArea((getBase()*getLado())/2);
    }

}
