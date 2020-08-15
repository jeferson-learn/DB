package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoPage {

    private WebDriver driver;

    public CarrinhoPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getYourCartTextLabel(){
        return driver.findElement(By.cssSelector(".subheader"));
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(By.cssSelector(".btn_action"));
    }
}
