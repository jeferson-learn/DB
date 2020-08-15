package OO.exercicio19;

public class Estoque {

    private static int cocaCola = 35;
    private static int pepsi = 25;
    private static int guarana = 30;

    private static int bolacha = 20;
    private static int salgadinho = 15;

    public static int getCocaCola() {
        return cocaCola;
    }

    public static void setCocaCola(int cocaCola) {
        Estoque.cocaCola = cocaCola;
    }

    public static int getPepsi() {
        return pepsi;
    }

    public static void setPepsi(int pepsi) {
        Estoque.pepsi = pepsi;
    }

    public static int getGuarana() {
        return guarana;
    }

    public static void setGuarana(int guarana) {
        Estoque.guarana = guarana;
    }

    public static int getBolacha() {
        return bolacha;
    }

    public static void setBolacha(int bolacha) {
        Estoque.bolacha = bolacha;
    }

    public static int getSalgadinho() {
        return salgadinho;
    }

    public static void setSalgadinho(int salgadinho) {
        Estoque.salgadinho = salgadinho;
    }

    public static void bebida(String tipos, int quantidade){
        switch (tipos){
            case "COCA":
                quantidade = getCocaCola() - quantidade;
                setCocaCola(quantidade);
                break;
            case "PEPSI":
                quantidade = getPepsi() - quantidade;
                setPepsi(quantidade);
                break;
            case "GUARANA":
                quantidade = getGuarana() - quantidade;
                setGuarana(quantidade);
                break;
            default:
                System.out.println("Não tem... ERROR");
        }
    }

    public static void comidas(String tipos, int quantidade){
        switch (tipos){
            case "BOLACHA":
                quantidade = getBolacha() - quantidade;
                setBolacha(quantidade);
                break;
            case "SALGADINHO":
                quantidade = getSalgadinho() - quantidade;
                setSalgadinho(quantidade);
                break;
            default:
                System.out.println("Não tem... ERROR");
        }
    }
}
