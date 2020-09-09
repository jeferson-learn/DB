package Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CreateLoginModel {

    private String nome;
    private String email;
    private String password;
    private String admin;

    @JsonPropertyOrder({"nome", "email", "password", "administrador"})
    public CreateLoginModel(){
        nome = "Jeferson";
        email = "jeferson1@teste.com";
        password = "123456";
        admin = "true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
