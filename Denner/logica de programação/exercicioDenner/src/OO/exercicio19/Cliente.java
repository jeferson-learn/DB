package OO.exercicio19;

public class Cliente {

    private static String nome;

    private static double valor = 0;

    public Cliente() {
    }

    public static double getValor() {
        return valor;
    }

    public static void setValor(double valor) {
        Cliente.valor = valor;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Cliente.nome = nome;
    }

    public static void total(double v) {
        valor = valor + v;
    }
}
