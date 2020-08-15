package support;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TirarFoto {

    private static final String CAMINHO_FOTO = System.getProperty("user.dir") + File.separator + "Relatorio" + File.separator + "Foto";

    public static MediaEntityModelProvider tirarFoto(WebDriver driver) throws IOException {

        CriarPasta.criarRelatorioPasta(CAMINHO_FOTO);

        //Converter o objeto de Webdriver para TakeScreenshot e vai Mover o arquivo de imagem para destino

        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String caminho = CAMINHO_FOTO + File.separator + foto.getName();

        FileUtils.copyFile(foto, new File(caminho));

        return MediaEntityBuilder.createScreenCaptureFromPath(caminho).build();

    }

    public static MediaEntityModelProvider tirarFotoBase64(WebDriver driver){
        try{
            CriarPasta.criarRelatorioPasta(CAMINHO_FOTO);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();
        }catch (Exception ex){

        }
        return null;
    }

}
