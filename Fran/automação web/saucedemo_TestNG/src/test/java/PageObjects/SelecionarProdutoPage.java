package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelecionarProdutoPage {

    private WebDriver driver;

    public SelecionarProdutoPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getProductsTextLabel(){
        return  driver.findElement(By.cssSelector(".product_label"));
    }

    public WebElement getImagemProdutoButton(){
        return driver.findElement(By.cssSelector("#item_1_img_link .inventory_item_img")); //CLICA IMAGEM
//        return driver.findElement(By.cssSelector("#item_1_title_link .inventory_item_name")); //CLICA LABEL
    }

    public WebElement getCarrinhosButton(){
        return driver.findElement(By.id("shopping_cart_container"));
    }

}
