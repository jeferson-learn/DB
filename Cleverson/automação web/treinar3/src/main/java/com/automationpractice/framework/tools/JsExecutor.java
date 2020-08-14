package com.automationpractice.framework.tools;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;

public class JsExecutor {
    public static void highLightElement(WebDriver driver, WebElement element){
        scriptElement(driver, element, HigtLight.RED.getArgument());
    }

    private static void scriptElement(WebDriver driver, WebElement element, String script) {
        try {
            if (driver instanceof JavascriptExecutor){
                ((JavascriptExecutor) driver).executeScript(script, element);
            }
        }catch (StaleElementReferenceException exception){
            Error.exception(Status.WARNING, "O elemento foi desvinculo do DOM atual." , exception , Shot.base64(driver));
        }catch (JavascriptException exception){
            Error.exception(Status.WARNING, "Não foi executar o comando JS.", exception, Shot.base64(driver));
        }
    }
}
