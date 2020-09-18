package Suite;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        CadastrarUsuarioTestCase.class,
        LoginTestCase.class,
        ListasProdutosTestCase.class,
        DeletarProdutoTestCase.class,
        DeletarUsuarioTestCase.class
})
public class DeletarProdutoSuiteTestCase {

}
