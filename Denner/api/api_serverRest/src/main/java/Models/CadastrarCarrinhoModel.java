package Models;

public class CadastrarCarrinhoModel {

    private String idProduto;
    private Integer quantidade;

    public CadastrarCarrinhoModel(String idProuto, Integer quantidade){
        this.idProduto = idProuto;
        this.quantidade = quantidade;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
