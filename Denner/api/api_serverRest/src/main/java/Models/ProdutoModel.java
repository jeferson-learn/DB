package Models;

public class ProdutoModel {

    private String nome;
    private String preco;
    private String descricao;
    private String quantidade;

    public ProdutoModel(){
        nome = "Teclado WEIBO";
        preco = "100";
        descricao = "Sem fio";
        quantidade = "15";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
