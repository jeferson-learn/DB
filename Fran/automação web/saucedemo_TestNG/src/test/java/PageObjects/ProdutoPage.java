package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage {
    private WebDriver driver;

    public ProdutoPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSwagLabsTextLabel(){
        return driver.findElement(By.cssSelector(".header_label"));
    }

    public WebElement getAddToCartButton(){
        return driver.findElement(By.cssSelector("#inventory_item_container .btn_primary"));
    }

    public WebElement getBackButton(){
        return driver.findElement(By.cssSelector(".inventory_details .inventory_details_back_button"));
    }

}
