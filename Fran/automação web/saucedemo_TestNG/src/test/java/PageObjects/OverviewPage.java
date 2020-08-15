package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {

    private WebDriver driver;

    public OverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCheckoutOverviewTextLabel(){
        return driver.findElement(By.cssSelector(".subheader"));
    }

    public WebElement getFinishButton(){
        return driver.findElement(By.cssSelector(".btn_action"));
    }

    public WebElement getMenuButton(){
        return driver.findElement(By.cssSelector(".bm-burger-button"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.id("logout_sidebar_link"));
    }
}
