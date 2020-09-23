package nomes;

import com.github.javafaker.Faker;

import java.util.Locale;

public class NomesFakers {

    private Faker faker;
    private String nomeCompleto;
    private String primeiroNome;
    private String sobreNome;

    public NomesFakers(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getNomeCompleto() {
        nomeCompleto = faker.name().fullName();
        return nomeCompleto;
    }

    public String getPrimeiroNome() {
        primeiroNome = faker.name().firstName();
        return primeiroNome;
    }

    public String getSobreNome() {
        sobreNome = faker.name().lastName();
        return sobreNome;
    }
}
