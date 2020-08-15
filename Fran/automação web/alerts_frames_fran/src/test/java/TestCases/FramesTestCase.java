package TestCases;

import Tasks.HomeFrameTask;
import Tasks.HomeTask;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import support.BaseTest;

public class FramesTestCase extends BaseTest {

    private static WebDriver driver = getDriver();
    HomeTask home = new HomeTask(driver);
    HomeFrameTask homeFrame = new HomeFrameTask(driver);

    @Test
    public void frameTest(){
        home.entrarFrame();
        homeFrame.frames();
    }
}
