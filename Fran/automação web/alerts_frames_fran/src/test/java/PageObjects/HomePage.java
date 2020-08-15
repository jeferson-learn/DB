package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAlertsJavaScriptButton(){
        return driver.findElement(By.id("alerttest"));
    }

    public WebElement getFakeAlertsButton(){
        return driver.findElement(By.id("fakealerttest"));
    }

    public WebElement getFrameButton(){
        return driver.findElement(By.id("framestest"));
    }

    public WebElement getIframeButton(){
        return driver.findElement(By.id("iframestest"));
    }
}
