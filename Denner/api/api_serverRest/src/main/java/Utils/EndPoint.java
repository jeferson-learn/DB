package Utils;

public class EndPoint {

    protected static final String EMAILEXISTE = ObjectsUtils.getPropertiesData("dadoLogin", "emailExiste");
    protected static final String PASSWORDEXISTE = ObjectsUtils.getPropertiesData("dadoLogin", "passwordExiste");

    protected static final String NOME = ObjectsUtils.getPropertiesData("dadoLogin", "nome");
    protected static final String EMAIL = ObjectsUtils.getPropertiesData("dadoLogin", "email");
    protected static final String PASSWORD = ObjectsUtils.getPropertiesData("dadoLogin", "password");
    protected static final String ADM = ObjectsUtils.getPropertiesData("dadoLogin", "administrador");

    protected static final String ID = ObjectsUtils.getPropertiesData("dadosUsuario", "ID");
    protected static final String TOKEN = ObjectsUtils.getPropertiesData("dadosUsuario", "TOKEN");



    protected static final String BASE_URI = ObjectsUtils.getPropertiesData("dadosEndPoint", "URI");
    protected static final String PATH_LOGIN = ObjectsUtils.getPropertiesData("dadosEndPoint", "LOGIN");
    protected static final String PATH_USUARIOS = ObjectsUtils.getPropertiesData("dadosEndPoint", "USUARIOS");
    protected static final String PATH_PRODUTOS = ObjectsUtils.getPropertiesData("dadosEndPoint", "PRODUTOS");

}