package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformacaoPage {

    private WebDriver driver;

    public InformacaoPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCheckoutYourInformationTextLabel(){
        return driver.findElement(By.className("subheader"));
    }

    public WebElement getFirstNameTextLabel(){
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameTextLabel(){
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCodeTextLabel(){
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton(){
        return driver.findElement(By.cssSelector(".btn_primary"));
    }

}
