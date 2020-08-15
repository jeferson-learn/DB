package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAlertsJavaScriptPage {

    private static WebDriver driver;

    public HomeAlertsJavaScriptPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAlertBoxExamplesTextLabel(){
        return driver.findElement(By.cssSelector(".page-body h1"));
    }

    public WebElement getShowAlertBoxButton(){
        return driver.findElement(By.id("alertexamples"));
    }

    public WebElement getShowConfirmBoxButton(){
        return driver.findElement(By.id("confirmexample"));
    }

    public WebElement getConfirmReturnTextLabel(){
        return driver.findElement(By.id("confirmreturn"));
    }

    public WebElement getShowPromptBoxButton(){
        return driver.findElement(By.id("promptexample"));
    }

    public WebElement getPromptReturnTextLabel(){
        return driver.findElement(By.id("promptreturn"));
    }
}
