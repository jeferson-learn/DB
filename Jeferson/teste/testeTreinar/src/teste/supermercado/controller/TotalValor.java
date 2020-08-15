package teste.supermercado.controller;

public class TotalValor {

    private double acu = 0;
    private double total;
    private double preco[] = new double[0];

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double[] getPreco() {
        return preco;
    }

    public void setPreco(double[] preco) {
        this.preco = preco;
    }

    public void recebeTotal(double valor){
        System.out.println(valor);
        setTotal(getTotal() + valor);
    }

    public void clienteRecebePreco(double valor){
        acu = acu + valor;
        preco[0] = acu;
    }
}
