package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeFramePage {

    private WebDriver driver;

    public HomeFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNestedFrameExampleTextLabel() {
        driver.switchTo().frame("top");
        return this.driver.findElement(By.cssSelector(".page-body h1"));
    }

    public WebElement getFrameLeftTextLabel() {
        driver.switchTo().frame("left");
        return this.driver.findElement(By.id("left1"));
    }

    public WebElement getFrameMiddleTextLabel(){
        driver.switchTo().frame("middle");
        return this.driver.findElement(By.id("middle11"));
    }

    public WebElement getFrameRightTextLabel(){
        driver.switchTo().frame("right");
        return this.driver.findElement(By.id("right27"));
    }
}