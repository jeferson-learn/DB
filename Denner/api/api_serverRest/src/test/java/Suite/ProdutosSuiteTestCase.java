package Suite;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages({"TestCase"})

@SelectClasses({
        CadastrarUsuarioTestCase.class,
        LoginTestCase.class,
        CadastrarProdutoTestCase.class,
        ListasProdutosTestCase.class,
        EditarProdutoTestCase.class,
        DeletarProdutoTestCase.class,
        DeletarUsuarioTestCase.class
})
public class ProdutosSuiteTestCase {

}


