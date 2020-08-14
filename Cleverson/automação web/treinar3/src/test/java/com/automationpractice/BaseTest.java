package com.automationpractice;

import com.automationpractice.framework.webdrivers.DriverFactory;
import com.automationpractice.framework.webdrivers.DriverManager;
import com.automationpractice.framework.webdrivers.Drivers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        WebDriver driver = DriverFactory.getInstance(Drivers.CHROME);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quit();
    }
}
