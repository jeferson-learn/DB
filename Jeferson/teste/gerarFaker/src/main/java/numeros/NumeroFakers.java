package numeros;

import com.github.javafaker.Faker;

import java.util.Locale;

public class NumeroFakers {

    private Faker faker;
    private String numeroDigit;
    private String numeroDigits;
    private int numeroRandomDigit;
    private int numberBetween;

    public NumeroFakers(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getNumeroDigit() {
        numeroDigit = faker.number().digit();
        return numeroDigit;
    }

    public String getNumeroDigits() {
        numeroDigits = faker.number().digits(5);
        return numeroDigits;
    }

    public int getNumeroRandomDigit() {
        numeroRandomDigit = faker.number().randomDigit();
        return numeroRandomDigit;
    }

    public int getNumberBetween() {
        numberBetween = faker.number().numberBetween(50, 60);
        return numberBetween;
    }

}
