package bola;

public class Brinquedo {

    private double preco;

    public Brinquedo(double preco) {
        this.preco = preco;
    }
    public Brinquedo() {

    }

    public void brincar(){
        System.out.println("Alguem está brincando com brinquedo");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
