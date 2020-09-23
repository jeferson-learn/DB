package internet;

import com.github.javafaker.Faker;

import java.util.Locale;

public class InternetFakers {

    private Faker faker;
    private String email1;
    private String email2;
    private String teste1;
    private String teste2;
    private String teste3;
    private String teste4;


    public InternetFakers(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getEmail1() {
        email1 = faker.internet().emailAddress();
        return email1;
    }

    public String getEmail2() {
        email2 = faker.internet().emailAddress("jeferson");
        return email2;
    }

    public String getTeste1() {
        teste1 = faker.internet().url();
        return teste1;
    }

    public String getTeste2() {
        teste2 = faker.internet().avatar();
        return teste2;
    }

    public String getTeste3() {
        teste3 = faker.internet().macAddress();
        return teste3;
    }

    public String getTeste4() {
        teste4 = faker.internet().password();
        return teste4;
    }
}
