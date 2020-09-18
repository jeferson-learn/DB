package Suite;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        CadastrarUsuarioTestCase.class,
        LoginTestCase.class,
        CadastrarProdutoTestCase.class,
        ListasProdutosTestCase.class,
        CadastrarCarrinhoTestCase.class,
        ListaCarrinhoTestCase.class,
        ConcluirComprarCarrinhoTestCase.class,
//        CancelarCompraCarrinhoTestCase.class,
        DeletarUsuarioTestCase.class
})
public class ApiServerestSuiteTestCase {

}
