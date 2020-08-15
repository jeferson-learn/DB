package teste.OO.publicStatic;

public class ClasseFuncao {

    private String comStatic = "TESTE com static";
    private String semStatic = "TESTE sem static";

    public String getComStatic() {
        return comStatic;
    }

    public void setComStatic(String comStatic) {
        this.comStatic = comStatic;
    }

    public String getSemStatic() {
        return semStatic;
    }

    public void setSemStatic(String semStatic) {
        this.semStatic = semStatic;
    }

    public void teste(){
//        semStatic();
//        comStatic();
//        setSemStatic("TESTE");
//        System.out.println(getSemStatic());
//        System.out.println(stringSemStatic());
//        System.out.println(stringComStatic());
//        System.out.println(numSemStatic());
//        System.out.println(numComStatic());
    }

    public void semStatic(){
        System.out.println("classe funcao: TESTE sem static");
    }

    public static void comStatic(){
        System.out.println("classe funcao: TESTE com static");
    }

    public String stringSemStatic(){
        String text = "sem static 'Sstring'";
        return text;
    }
    public static String stringComStatic(){
        return "com static 'Sstring'";
    }

    public int numSemStatic(){
        int num = 0;
        return num;
    }
    public static int numComStatic(){
        int num = 1;
        return num;
    }


}
