package com.automationpractice;

import com.automationpractice.framework.tools.Report;
import com.automationpractice.framework.webdrivers.DriverManager;
import com.automationpractice.framework.widgets.ITextField;
import com.automationpractice.framework.widgets.web.TextField;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeTestCase extends BaseTest{

    @Test
    public void test(){
        Report.createTest("TESTE");
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        Report.log(Status.INFO, "Acessando o site AUTOMATIONPRACTICE");

        ITextField campoSearchTextField = new TextField(driver,By.id("search_query_top"));
        campoSearchTextField.setText("TESTE 2");
        campoSearchTextField.setKeys(Keys.ENTER);

        Report.close();
    }
}
