package barrigaFW;

import utils.ObjectsUtils;

public class EndPoint {

    protected static final String BASE_URL = ObjectsUtils.getPropertiesData("PathsEndPoints", "base_url");
    protected static final String BASE_PORT4 = ObjectsUtils.getPropertiesData("PathsEndPoints", "base_port4");
    protected static final String BASE_PORT8 = ObjectsUtils.getPropertiesData("PathsEndPoints", "base_port8");
    protected static final String BASE_USERS = ObjectsUtils.getPropertiesData("PathsEndPoints", "base_users");
    protected static final String BASE_CONTAS = ObjectsUtils.getPropertiesData("PathsEndPoints", "base_contas");

}
