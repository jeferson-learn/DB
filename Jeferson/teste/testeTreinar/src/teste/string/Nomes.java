package teste.string;

import java.util.StringTokenizer;

public class Nomes {

    public static void main(String[] args) {
        String nameFull = "Jeferson Lopes Eugenio";

        /* Pega primeiro letra */
        String primeiraLetra = nameFull.substring(nameFull.indexOf(" "));

        System.out.println("Nome completo: " + nameFull);
        System.out.println("Nome: " + primeiraLetra);
        /* ----------------------------- */

        /* Pega ultimo nome completo */
        String teste2 = null;
        StringTokenizer teste = new StringTokenizer("Jeferson Lopes Eugenio"," ");
        while(teste.hasMoreTokens()){
            teste2 = teste.nextToken();
        }
        System.out.println(teste2);
        /* -------------------------- */

        nomeCompleto(nameFull);

    }

        public static String nomeCompleto(String nomeFull){
            return nomeFull;
        }

        public String primeiroNome(String nomeFull){
            String partes[] = nomeFull.split(" ");
            String nome;
            for (int i = partes.length; i <= partes.length && i != 0; i--){
                if (i==partes.length){
                    nome = partes[partes.length-i];
                    return nome;
                }
            }
            return null;
        }

        public String segundoNome(String nomeFull){
            String partes[] = nomeFull.split(" ");
            String nome;
            for (int i = partes.length; i <= partes.length && i != 0; i--){
                if (i==partes.length){
                    nome = partes[partes.length-(i-1)];
                    return nome;
                }
            }
            return null;
        }

        public String terceiroNome(String nomeFull){
            String partes[] = nomeFull.split(" ");
            String nome;
            for (int i = partes.length; i <= partes.length && i != 0; i--){
                if (i==partes.length){
                    nome = partes[partes.length-(i-2)];
                    return nome;
                }
            }
            return null;
        }

        public String quatroNome(String nomeFull){
            String partes[] = nomeFull.split(" ");
            String nome;
            for (int i = partes.length; i <= partes.length && i != 0; i--){
                if (i==partes.length){
                    nome = partes[partes.length-(i-3)];
                    return nome;
                }
            }
            return null;
        }

        public String sobreNome(String nomeFull){
            String partes[] = nomeFull.split(" ");
            String nome1, nome2, nome3;
            for (int i = partes.length; i <= partes.length && i != 0; i--){
                if (i==partes.length){
                    nome1 = partes[partes.length-(i-1)];
                    nome2 = partes[partes.length-(i-2)];
                    nome3 = partes[partes.length-(i-3)];
                    return nome1 + " " + nome2 + " " + nome3;
                }
            }
            return null;
        }

    }

