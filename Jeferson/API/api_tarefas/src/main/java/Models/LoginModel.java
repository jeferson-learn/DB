package Models;

public class LoginModel {

    private String email;
    private String password;

    public LoginModel(String email, String senha){
        this.email = email;
        this.password = senha;
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
