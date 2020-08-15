package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class GerenciadorDriver {

    private static WebDriver driver;
    private static WebDriver getGerenciadorDriver(Driver tipo){
        switch (tipo){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opcoes = new ChromeOptions();
                opcoes.addArguments("--start-maximized");
                driver = new ChromeDriver(opcoes);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case IE:
//                WebDriverManager.edgedriver().setup();
                WebDriverManager.iedriver().setup();
                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver();
                break;
            case HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions segundoplano = new ChromeOptions();
                segundoplano.addArguments("--headless");
                segundoplano.addArguments("--window-size(1366,768)");
                driver = new ChromeDriver(segundoplano);
                break;
            default:
                break;
        }
        return driver;
    }

    public static WebDriver pegarDriver (Driver tipo){
        if (driver == null) {
            driver = getGerenciadorDriver(tipo);
        }
        return driver;
    }

    public static void fecharDriver(){
        if ( driver!=null ){
            driver.close();
            driver = null;
        }
    }

}
