package support;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GeradorFakers {

    private Faker faker;
    private String primeiroNome;
    private String sobreNome;
    private String postal;

    public GeradorFakers(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getPrimeiroNome(){
        primeiroNome = faker.name().firstName();
        return primeiroNome;
    }

    public String getSobreNome(){
        sobreNome = faker.name().lastName();
        return sobreNome;
    }

    public String getPostal(){
        postal = faker.address().zipCode();
        return postal;
    }


}
