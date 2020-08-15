package teste;

public class ForWithIF {
    public static void main(String[] args) {
        String produto[] = new String[2];
        int itens[] = new int[2];

        produto[0] = "Jeferson";
        produto[1] = "Lopes";

        itens[0] = 8;
        itens[1] = 15;

        for (String nome : produto){
            System.out.println(nome);
            for (int quantidade : itens) {
                System.out.println(itens);
            }
        }

        for (int i=0; i<itens.length; i++){
            if (produto.equals("jeferson")){
                System.out.println("certo" + i);
            }else{
                System.out.println("errado");
            }
        }
    }
}
