package com.automationpractice.framework.tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.IOException;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

public class Shot {
    public static MediaEntityModelProvider base64(WebDriver driver){
        try {
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            ImageIO.write(screenshot.getImage(), "png", stream);
            String base64Image = encodeBase64String(stream.toByteArray());

            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build();
        } catch ( ScreenshotException | IOException e) {
            String message = "Ocorreu uma falha na capture de tela.";
            Error.exception(Status.WARNING, message, e);
        }
        return null;
    }
}
