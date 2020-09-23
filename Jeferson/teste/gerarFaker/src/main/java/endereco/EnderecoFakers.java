package endereco;

import com.github.javafaker.Faker;

import java.util.Locale;

public class EnderecoFakers {

    private Faker faker;
    private String enderecoCompleto;
    private String cidade;
    private String cidadeNome;
    private String estado;
    private String pais;
    private String postal;

    public EnderecoFakers(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getEnderecoCompleto() {
        enderecoCompleto = faker.address().fullAddress();
        return enderecoCompleto;
    }

    public String getCidade() {
        cidade = faker.address().city();
        return cidade;
    }

    public String getCidadeNome() {
        cidadeNome = faker.address().cityName();
        return cidadeNome;
    }

    public String getEstado() {
        estado = faker.address().state();
        return estado;
    }

    public String getPais() {
        pais = faker.address().country();
        return pais;
    }

    public String getPostal() {
        postal = faker.address().zipCode();
        return postal;
    }
}
