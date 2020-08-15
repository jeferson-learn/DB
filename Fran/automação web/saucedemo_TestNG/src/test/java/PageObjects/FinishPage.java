package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {

    private WebDriver driver;

    public FinishPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFinishTextLabel(){
        return driver.findElement(By.cssSelector(".subheader"));
    }
}
