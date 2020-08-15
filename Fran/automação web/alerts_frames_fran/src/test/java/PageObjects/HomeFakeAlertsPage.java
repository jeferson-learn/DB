package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeFakeAlertsPage {

    private WebDriver driver;
    private HomePage home;

    public HomeFakeAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFakeAlertBoxExamplesTextLabel(){
        return driver.findElement(By.cssSelector(".page-body h1"));
    }

    public WebElement getShowAlertBoxButton(){
        return driver.findElement(By.id("fakealert"));
    }

//    public WebElement getIAmAFakeAlertBoxTextLabel(){
//        return driver.findElement(By.id(""));
//    }

    public WebElement getModalOkButton(){
        return driver.findElement(By.id("dialog-ok"));
    }
}
