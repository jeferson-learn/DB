package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Wait;

public class ListaFuncionalidadesPageObjects {

    private WebDriver driver;
    private Wait wait;

    public ListaFuncionalidadesPageObjects(WebDriver driver){
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getBemVindoTextLabel(){
//        return driver.findElement(By.cssSelector("h5.orange-text"));
        return wait.waitVisibilidadeElement(By.cssSelector("h5.orange-text"));
    }

    public WebElement getMenuFormularioButton(){
        return driver.findElement(By.cssSelector(".collapsible.collapsible-accordion .collapsible-header"));
    }

    public WebElement getMenuFormularioCriarUsuarioButton(){
        return driver.findElement(By.cssSelector(".collapsible.collapsible-accordion a[href='/users/new']"));
    }

    public WebElement getNovoUsuarioTextLabel(){
        return driver.findElement(By.cssSelector("h5.center"));
    }

    public WebElement getNameTextLabel(){
        return driver.findElement(By.id("user_name"));
    }

    public WebElement getLastNameTextLabel(){
        return driver.findElement(By.id("user_lastname"));
    }

    public WebElement getEmailTextLabel(){
        return driver.findElement(By.id("user_email"));
    }

    public WebElement getEnderecoTextLabel(){
        return driver.findElement(By.id("user_address"));
    }

    public WebElement getUniversidadeTextLabel(){
        return driver.findElement(By.id("user_university"));
    }

    public WebElement getProfissaoTextLabel(){
        return driver.findElement(By.id("user_profile"));
    }

    public WebElement getGeneroTextLabel(){
        return driver.findElement(By.id("user_gender"));
    }

    public WebElement getIdadeTextLabel(){
        return driver.findElement(By.id("user_age"));
    }

    public WebElement getCriarButton(){
        return driver.findElement(By.name("commit"));
    }

    public WebElement getUsuarioCriadoComSucessoTextLabel(){
        return driver.findElement(By.id("notice"));
    }

    public WebElement getVoltarButton(){
        return driver.findElement(By.cssSelector(".btn.red"));
    }

    public WebElement getVoltarHomeButton(){
        return driver.findElement(By.cssSelector("a.btn.red"));
    }

}
