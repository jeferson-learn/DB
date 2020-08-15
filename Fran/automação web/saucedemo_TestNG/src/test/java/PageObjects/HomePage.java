package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUsuarioTextLabel(){
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getSenhaTextLabel(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("input.btn_action"));
    }
}
