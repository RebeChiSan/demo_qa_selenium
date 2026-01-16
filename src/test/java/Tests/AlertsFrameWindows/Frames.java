package Tests.AlertsFrameWindows;

import Pages.AlertsFramesWindowsPage;
import Pages.HomePage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames extends BaseTest {
    HomePage homePage;
    AlertsFramesWindowsPage framesPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        framesPage = new AlertsFramesWindowsPage(driver);
    }

    @Test(description = "TC001: Validate frame content")
    public void validateFramesContent() {
        homePage.clickOnAlerts();
        framesPage.clickOnFramesOption();
        framesPage.switchToFrameNumber(2);
        Assert.assertEquals(framesPage.getFrameHeadingText(),"This is a sample page");
        framesPage.switchToDefaultContent();
        framesPage.switchToFrameNumber(1);
        Assert.assertEquals(framesPage.getFrameHeadingText(),"This is a sample page");
        framesPage.switchToDefaultContent();
    }

}
