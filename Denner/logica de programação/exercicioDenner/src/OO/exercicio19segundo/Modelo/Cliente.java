package OO.exercicio19segundo.Modelo;

import static OO.exercicio19.Input.inputString;

public class Cliente {

    private String nome;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void defineCliente() {
        System.out.print("Nome do cliente: ");
        setNome(inputString());
    }

}
