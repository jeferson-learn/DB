package teste.string;

public class Split {

    public static void main(String[] args) {

        String nome = "JefersonLopesEugenio";

        String[] split1 = nome.split("L");

        System.out.println(split1[1]);

        int split2 = nome.split("J").length;

        System.out.println(split2);


    }

}
