package Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email","password"})
public class LoginModel {

    private String email;
    private String password;

    public LoginModel(){
        email = "jefersonlopeseugenio@test.com.br";
        password = "123456";
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
}
