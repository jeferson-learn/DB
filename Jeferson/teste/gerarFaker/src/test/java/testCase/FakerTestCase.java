package testCase;

import endereco.EnderecoFakers;
import internet.InternetFakers;
import nomes.NomesFakers;
import numeros.NumeroFakers;
import org.junit.jupiter.api.Test;

public class FakerTestCase {

    NomesFakers nomesFakers = new NomesFakers();
    InternetFakers internetFakers = new InternetFakers();
    EnderecoFakers enderecoFakers = new EnderecoFakers();
    NumeroFakers numeroFakers = new NumeroFakers();

    @Test
    public void teste(){
        System.out.println(internetFakers.getBoolean());
    }

    @Test
    public void nomes(){
        String nomeCompleto = nomesFakers.getNomeCompleto();
        String primeiroNome = nomesFakers.getPrimeiroNome();
        String sobreNome = nomesFakers.getSobreNome();

        System.out.println("Nome completo: " + nomeCompleto);
        System.out.println("Primeiro nome: " + primeiroNome);
        System.out.println("Sobrenome: " + sobreNome);

    }

    @Test
    public void emails(){
        String email1 = internetFakers.getEmail1();
        String email2 = internetFakers.getEmail2();
//        String url = internetFakers.getTeste1();
//        String avatar = internetFakers.getTeste2();
//        String macAdress = internetFakers.getTeste3();
//        String senha = internetFakers.getTeste4();


        System.out.println("Email 1: " + email1);
        System.out.println("Email 2: " + email2);
//        System.out.println("url: " + url);
//        System.out.println("avatar: " + avatar);
//        System.out.println("macAdress: " + macAdress);
//        System.out.println("senha: " + senha);
    }

    @Test
    public void endereco(){
        String nomeEndereco = enderecoFakers.getEnderecoCompleto();
        String cidade = enderecoFakers.getCidade();
        String cidadeNome = enderecoFakers.getCidadeNome();
        String estado = enderecoFakers.getEstado();
        String pais = enderecoFakers.getPais();
        String postal = enderecoFakers.getPostal();


        System.out.println("Nome endereco: " + nomeEndereco);
        System.out.println("Cidade: " + cidade);
        System.out.println("Cidade nome: " + cidadeNome);
        System.out.println("Nome estado: " + estado);
        System.out.println("Nome pais: " + pais);
        System.out.println("numero code postal: " + postal);
    }

    @Test
    public void numero() {
//        String numeroDigito = numeroFakers.getNumeroDigit();
//        String numeroDigitos = numeroFakers.getNumeroDigits();
//        int numeroRandomDigito = numeroFakers.getNumeroRandomDigit();
//        int numeroBetween = numeroFakers.getNumberBetween();
        for(int i = 1; i <= 10; i++){
//            String numeroDigito = numeroFakers.getNumeroDigit();
//            String numeroDigitos = numeroFakers.getNumeroDigits();
//            int numeroRandomDigito = numeroFakers.getNumeroRandomDigit();
            int numeroBetween = numeroFakers.getNumberBetween();
            System.out.println(i + " - Numero: " + numeroBetween);
        }

//        System.out.println("Numero digito: " + numeroDigito);
//        System.out.println("Numero digitos: " + numeroDigitos);
//        System.out.println("Numero random digito: " + numeroRandomDigito);
//        System.out.println("Numero between: " + numeroBetween);
    }

}
