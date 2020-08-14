package com.automationpractice.framework.webdrivers;

import com.automationpractice.framework.tools.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getInstance(Drivers drivers){
        switch (drivers){
            case CHROME:
                Log.info("Inicializando instancia de Chrome Driver");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                Log.info("Inicializando instancia de Firefox Driver");
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                Log.info("Inicializando instancia de Edge Driver");
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
        }
        return null;
    }
}
