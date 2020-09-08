package arquivos;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static io.restassured.RestAssured.*;

public class FileTest {

    @Test
    public void deveObrigarEnviarArquivo(){
    given()
            .log().all()
    .when()
            .post("https://restapi.wcaquino.me/upload")
    .then()
            .log().all()
            .statusCode(404)
            .body("error", is("Arquivo não enviado"));
    }

    @Test
    public void deveFazerUploadArquivo(){
    given()
            .log().all()
            .multiPart("arquivo", new File("src/main/resources/users.pdf"))
    .when()
            .post("https://restapi.wcaquino.me/upload")
    .then()
            .log().all()
            .statusCode(200)
            .body("name", is("users.pdf"));
    }

    @Test
    public void naoDeveFazerUploadArquivoGrande(){
    given()
            .log().all()
            .multiPart("arquivo", new File("src/main/resources/samsung.zip"))
    .when()
            .post("https://restapi.wcaquino.me/upload")
    .then()
            .log().all()
            .time(lessThan(4000L))
            .statusCode(413);
    }

    @Test
    public void deveBaixarArquivo() throws IOException {
    byte[] image =
    given()
            .log().all()
    .when()
            .get("https://restapi.wcaquino.me/download")
    .then()
//            .log().all()
            .statusCode(200)
            .extract().asByteArray();

    File imagem = new File("src/main/resources/file.jpg");
        OutputStream out = new FileOutputStream(imagem);
        out.write(image);
        out.close();

        System.out.println("tamanho: " + imagem.length());
        Assert.assertThat(imagem.length(), lessThan(100000L));

    }

}