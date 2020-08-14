package com.automationpractice.framework.widgets.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperWebElement {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected By byElement;

    public SuperWebElement(WebDriver driver, By by){
        webDriver = driver;
        byElement = by;
        wait = new WebDriverWait(driver, 30);
    }

    public String getElementName(WebElement element){
        if (element != null){
            if (!element.getText().isEmpty()){
                return element.getText();
            } else if (element.getAttribute("name") != null && !element.getAttribute("name").isEmpty()){
                return element.getAttribute("name");
            } else if (element.getAttribute("value") != null && !element.getAttribute("value").isEmpty()){
                return element.getAttribute("value");
            }
        }
        return "sem nome";
    }
}
