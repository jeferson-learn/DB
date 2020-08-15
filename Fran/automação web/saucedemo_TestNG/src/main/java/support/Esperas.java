package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Esperas {

    private WebDriverWait espera;
    private WebDriver driver;

    /*public Esperas(WebDriver driver){
        espera = new WebDriverWait(driver, 20);
    }

    public WebElement esperaVisibilidadeDoElemento(By by){
        return espera.until(ExpectedConditions.visibilityOfElementLocated(by));
    }*/

    //OU

    public Esperas(WebDriver driver){
        this.driver = driver;
    }

    public WebElement esperaVisibilidadeDoElemento(By by){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        return espera.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement esperaCarregarElemento(WebElement elemento){
        WebDriverWait espera = new WebDriverWait(driver, 30);
        return espera.until(ExpectedConditions.visibilityOf(elemento));
    }

}
