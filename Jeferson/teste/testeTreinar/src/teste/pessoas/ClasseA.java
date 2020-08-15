package teste.pessoas;

public class ClasseA {

    Pessoa p = new Pessoa("Jeferson", 27);

    public void a(){
        p.setValor(100);
    }

    public void apresentar(){
        System.out.println(p.getNome());
        System.out.println(p.getIdade());
        System.out.println(p.getValor());
    }
}
