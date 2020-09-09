package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {

    private String email;
    private String password;

    public LoginModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    public LoginModel(){
        email = "fulano@qa.com";
        password = "teste";
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

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
