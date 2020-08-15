package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeIframePage {

    private WebDriver driver;

    public HomeIframePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getIframesExampleTextLabel(){
        return driver.findElement(By.cssSelector(".page-body h1"));
    }

    public WebElement getIframeExampleListTextLabel(){
        driver.switchTo().frame("thedynamichtml");
        return this.driver.findElement(By.id("iframe0"));
    }

    public WebElement getIframeExampleHeaderTextLabel(){
        driver.switchTo().frame("theheaderhtml");
        return driver.findElement(By.cssSelector("div[class='theheaderhtml .page-body .explanation p']"));
    }
}