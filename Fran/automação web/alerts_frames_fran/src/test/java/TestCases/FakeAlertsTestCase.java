package TestCases;

import Tasks.HomeFakeAlertsTask;
import Tasks.HomeTask;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import support.BaseTest;

public class FakeAlertsTestCase extends BaseTest {

    private static WebDriver driver = getDriver();
    HomeTask home = new HomeTask(driver);
    HomeFakeAlertsTask fakeAlerts = new HomeFakeAlertsTask(driver);

    @Test
    public void fakeAlertsTest() throws InterruptedException {
        home.entrarFakeAlerts();
        fakeAlerts.showAlertBox();
    }

}
