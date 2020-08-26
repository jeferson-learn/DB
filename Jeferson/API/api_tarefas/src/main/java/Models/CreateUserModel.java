package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "password", "password_confirmation"})
public class CreateUserModel {

    private String email;
    private String password;
    private String password_confirmation;

    public CreateUserModel(){
        email = "testes1@testes.com";
        password = "123456";
        password_confirmation = "123456";
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

    @JsonProperty("password_confirmation")
    public String getPassword_confirmation() {
        return password_confirmation;
    }

    @JsonProperty("password_confirmation")
    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}
