package Utils;

public class EndPoints {

    protected static final String EMAIL = ObjectsUtils.getPropertiesData("dadosUsuario", "email");
    protected static final String PASSWORD = ObjectsUtils.getPropertiesData("dadosUsuario", "password");

    protected static final String BASE_URI = ObjectsUtils.getPropertiesData("caminhoEndPoints", "url");
    protected static final String BASE_PATH_USER = ObjectsUtils.getPropertiesData("caminhoEndPoints", "user");
    protected static final String BASE_PATH_SESSIONS = ObjectsUtils.getPropertiesData("caminhoEndPoints", "sessions");

}
