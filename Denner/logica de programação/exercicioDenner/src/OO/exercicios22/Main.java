package OO.exercicios22;

public class Main {
    public static void main(String[] args) {

        Pessoa joao = new Pessoa("Joao",80,null,null);
        Pessoa maria = new Pessoa("Maria",85,null,null);
        Pessoa jose = new Pessoa("Jose",50,joao,maria);
        Pessoa tereza = new Pessoa("Tereza",45,null,maria);
        Pessoa manoel = new Pessoa("Manoel",15,null,tereza);

        System.out.println(manoel.getMae().getMae().getIdade());


    }
}
