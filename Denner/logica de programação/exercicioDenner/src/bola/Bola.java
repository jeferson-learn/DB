package bola;

public class Bola extends Brinquedo{
    private String cor;
    private int peso;
    private int tamanho;

    public Bola(String cor, int peso, int tamanho, double preco) {
        super(preco);
        this.cor = cor;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public void quicar(){
        System.out.println("A bola está quicando");
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
