package support;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

    private static final String CAMINHO_FOTO = System.getProperty("user.dir") + File.separator + "Relatorio" + File.separator + "Foto";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy_hh'h'mm'm's's'");
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final String ldtString = dateTimeFormatter.format(localDateTime);

    public static MediaEntityModelProvider screenshot(WebDriver driver) throws IOException {

        CriarPasta.criarRelatorioPasta(CAMINHO_FOTO);

        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String caminho = CAMINHO_FOTO + File.separator + foto.getName();
//        String caminho = CAMINHO_FOTO + File.separator + foto + ldtString;

        FileUtils.copyFile(foto, new File(caminho));

        return MediaEntityBuilder.createScreenCaptureFromPath(caminho).build();
    }

    public static MediaEntityModelProvider screenshotBase64(WebDriver driver){
        try{
            CriarPasta.criarRelatorioPasta(CAMINHO_FOTO);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();
        }catch (Exception exception){

        }
        return null;
    }
}
