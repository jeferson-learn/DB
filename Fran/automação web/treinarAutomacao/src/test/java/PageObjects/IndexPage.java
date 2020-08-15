package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAutomacaoWebButton(){
        return driver.findElement(By.cssSelector("#index-banner .btn"));
    }
}
