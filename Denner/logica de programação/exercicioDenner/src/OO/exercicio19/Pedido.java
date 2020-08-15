package OO.exercicio19;

public class Pedido extends Produtos{
    private int item, produtos;

//    public Pedido(int item, int produtos, double preco, int quantidade) {
//        super(preco, quantidade);
//        this.item = item;
//        this.produtos = produtos;
//    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void pegar(){
        if (item<produtos){
            produtos = produtos - item;
        }
    }
}
