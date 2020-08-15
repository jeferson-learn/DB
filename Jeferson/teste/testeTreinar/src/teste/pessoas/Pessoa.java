package teste.pessoas;

public class Pessoa {

    private String nome;
    private int idade;
    private double valor;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.valor = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
