package teste.pessoas;

public class ClasseB {

    Pessoa p = new Pessoa("Thaviny", 20);

    public void b(){
        p.setValor(200);
    }

    public void apresentar(){
        System.out.println(p.getNome());
        System.out.println(p.getIdade());
        System.out.println(p.getValor());
    }
}
