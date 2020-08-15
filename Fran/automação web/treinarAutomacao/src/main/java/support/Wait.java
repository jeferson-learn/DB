package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriver driver;
    private WebDriverWait wait;

    public Wait(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitVisibilidadeElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

//    public WebElement waitCarregarElement(WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        return wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public WebElement waitCarregarElement(WebElement element){
        try{
            return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e){
            return element;
        }
    }

}
