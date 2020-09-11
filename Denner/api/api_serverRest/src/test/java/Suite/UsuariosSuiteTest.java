package Suite;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CadastrarUsuarioTestCase.class, LoginTestCase.class, ListaUsuarioTestCase.class, EditarUsuarioTestCase.class, DeletarUsuario.class})
public class SuiteTest {

}
