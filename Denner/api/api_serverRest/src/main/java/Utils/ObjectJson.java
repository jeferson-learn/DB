package Utils;

import org.json.JSONObject;

public class ObjectJson extends EndPoint {


    private static String email = EMAILEXISTE;
    private static String password = PASSWORDEXISTE;

    private static String createNome = NOME;
    private static String createEmail = EMAIL;
    private static String createPassword = PASSWORD;
    private static String createAdm = ADM;


    public static String loginExisteJsonObject(){

        JSONObject login = new JSONObject();
        login.put("email", createEmail);
        login.put("password", createPassword);

        return login.toString();
    }

    public static String createLoginJsonObject(){

        JSONObject login = new JSONObject();
        login.put("nome", createNome);
        login.put("email", createEmail);
        login.put("password", createPassword);
        login.put("administrador", createAdm);

        return login.toString();
    }
}
