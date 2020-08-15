package OO.exercicio19segundo;

import java.util.ArrayList;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int acuCoca = 0;
    private int acuPepsi = 0;
    private int acuGuarana = 0;
    private int acuBolacha = 0;
    private int acuSalgadinho = 0;
    private String produto[] = new String[5];
    private int itens[] = new int[5];

    public Produto() {

    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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

    public int getAcuGuarana() {
        return acuGuarana;
    }

    public void setAcuGuarana(int acuGuarana) {
        this.acuGuarana = acuGuarana;
    }

    public int getAcuBolacha() {
        return acuBolacha;
    }

    public void setAcuBolacha(int acuBolacha) {
        this.acuBolacha = acuBolacha;
    }

    public int getAcuSalgadinho() {
        return acuSalgadinho;
    }

    public void setAcuSalgadinho(int acuSalgadinho) {
        this.acuSalgadinho = acuSalgadinho;
    }

    public String[] getProduto() {
        return produto;
    }

    public void setProduto(String[] produto) {
        this.produto = produto;
    }

    public int[] getItens() {
        return itens;
    }

    public void setItens(int[] itens) {
        this.itens = itens;
    }

    public void configuracaoInicial(ArrayList<Produto> bebidas, ArrayList<Produto> comidas) {
        adicionaProdutosNaListaDeBebidas(bebidas);
        adicionaProdutosNaListaDeComidas(comidas);
    }

    public void adicionaProdutosNaListaDeBebidas(ArrayList<Produto> bebidas) {
        Produto coca = new Produto("Coca", 5.5, 35);
        Produto pepsi = new Produto("Pepsi", 5.0, 25);
        Produto guarana = new Produto("Guarana", 4.5, 30);

        bebidas.add(coca);
        bebidas.add(pepsi);
        bebidas.add(guarana);
    }

    public void adicionaProdutosNaListaDeComidas(ArrayList<Produto> comidas) {
        Produto bolacha = new Produto("Bolacha", 2.5, 20);
        Produto salgadinho = new Produto("Salgadinho", 4.0, 15);

        comidas.add(bolacha);
        comidas.add(salgadinho);
    }

    public void guardaProdutoQuantidade(String nome, int quantidade) {
        switch (nome.toUpperCase()) {
            case "COCA":
                setAcuCoca(getAcuCoca() + quantidade);
                produto[0] = nome;
                itens[0] = getAcuCoca();
                break;
            case "PEPSI":
                setAcuPepsi(getAcuPepsi() + quantidade);
                produto[1] = nome;
                itens[1] = getAcuPepsi();
                break;
            case "GUARANA":
                setAcuGuarana(getAcuGuarana() + quantidade);
                produto[2] = nome;
                itens[2] = getAcuGuarana();
                break;
            case "BOLACHA":
                setAcuBolacha(getAcuBolacha() + quantidade);
                produto[3] = nome;
                itens[3] = getAcuBolacha();
                break;
            case "SALGADINHO":
                setAcuSalgadinho(getAcuSalgadinho() + quantidade);
                produto[4] = nome;
                itens[4] = getAcuSalgadinho();
                break;
            default:
                System.out.println("NÃO TEM OUTRO PRODUTO");
        }
    }

    public void array(){
        System.out.println("array");
        System.out.println(produto.length);
        for (int i = 0; i < produto.length; i++) {
            if (produto[i] != null) {
                System.out.println("teste dentro");
                System.out.println(produto[i] + ": " + itens[i]);
            }
        }
    }

}