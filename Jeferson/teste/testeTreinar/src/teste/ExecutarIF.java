package teste;

public class ExecutarIF {
    public static void main(String[] args) {

        String teste = "teste";
        String test = "test";

        if (teste == "teste"){
            System.out.println("DEU TESTE");
        } else {
            System.out.println("NAO DEU TESTE");
        }

        if (test.equalsIgnoreCase("test")){
            System.out.println("DEU TEST");
        }else {
            System.out.println("NAO DEU TEST");
        }
    }
}
