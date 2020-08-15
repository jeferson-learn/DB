package teste.supermercado.model;

import teste.supermercado.controller.TotalValor;

public class Produtos {

    private int acuCoca = 0;
    private int acuPepsi = 0;
    private String produtos[] = new String[5];
    private int itens[] = new int[5];
    TotalValor totalValor = new TotalValor();

    public int getAcuCoca() {
        return acuCoca;
    }

    public void setAcuCoca(int acuCoca) {
        this.acuCoca = acuCoca;
    }

    public int getAcuPepsi() {
        return acuPepsi;
    }

    public void setAcuPepsi(int acuPepsi) {
        this.acuPepsi = acuPepsi;
    }

    public void clientePegouProdutoQuantidadeValor(String produto, int qts, double valor){
        switch (produto){
            case "coca":
                setAcuCoca(getAcuCoca() + qts);
                produtos[0] = produto;
                itens[0] = getAcuCoca();

                break;
            case"pepsi":
                break;
            default:
                System.out.println("Invalido");
        }
    }

}
