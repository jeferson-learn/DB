package com.automationpractice.framework.widgets.web;

import com.automationpractice.framework.tools.Error;
import com.automationpractice.framework.tools.JsExecutor;
import com.automationpractice.framework.tools.Report;
import com.automationpractice.framework.tools.Shot;
import com.automationpractice.framework.widgets.ITextField;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextField extends SuperWebElement implements ITextField {

    public TextField(WebDriver driver, By by) {
        super(driver, by);
    }

    @Override
    public ITextField setText(String text) {
        try {
            WebElement elementVisibility = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
            WebElement elementCickable = wait.until(ExpectedConditions.elementToBeClickable(elementVisibility));
            JsExecutor.highLightElement(webDriver,elementCickable);
            String elementName = getElementName(elementCickable);
            elementCickable.sendKeys(text);
            Report.log(Status.INFO, "Foi inserido [" + text + "] no campo de texto " + byElement);
        } catch (ElementClickInterceptedException e){
            String message = "O elemento " + byElement.toString() + "existente no DOM e tem um conjunto de recursos como oculto.";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        } catch(NoSuchElementException e) {
            String message = "O elemento não pode ser encontrado";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        } catch(StaleElementReferenceException e) {
            String message = "O elemento foi desvinculo do DOM atual.";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        } catch(TimeoutException e) {
            String message = "O elemento pesquisando não foi encontrado no tempo especificado.";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        } catch(InvalidElementStateException e) {
            String message = "O comando não pode ser finalizado, pois o elemento é invalido.";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        }
        return null;
    }

    @Override
    public ITextField setKeys(Keys keys) {
        try {
            WebElement element = webDriver.findElement(byElement);
            element.sendKeys(keys);
        }catch (ElementClickInterceptedException e){
            String message = "Não foi possivel realizar a operação devida falha ao encontrar o objeto.";
            Error.exception(Status.FAIL, message, e, Shot.base64(webDriver));
            throw new RuntimeException(message, e);
        }
        return null;
    }
}
