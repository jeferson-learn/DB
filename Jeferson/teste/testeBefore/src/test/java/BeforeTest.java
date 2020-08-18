import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeTest {

//    @BeforeAll
    public void beforeAll(){
        System.out.println("BEFORE ALL");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("BEFORE EACH");
    }

    @Test
    public void setUp1(){
        System.out.println("Teste 1");
    }
    @Test
    public void setUp2(){
        System.out.println("Teste 2");
    }
    @Test
    public void setUp3(){
        System.out.println("Teste 3");
    }
}
