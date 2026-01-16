package Tests.AlertsFrameWindows;

import Pages.AlertsFramesWindowsPage;
import Pages.HomePage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrames extends BaseTest {
    HomePage homePage;
    AlertsFramesWindowsPage nestedFramesPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        nestedFramesPage = new AlertsFramesWindowsPage(driver);
    }

    @Test(description = "TC001: Validate frame content")
    public void validateNestedFramesContent() {
        homePage.clickOnAlerts();
        nestedFramesPage.clickOnNestedFrames();
        nestedFramesPage.switchToNestedFrame(1);
        Assert.assertEquals(nestedFramesPage.getNestedFrameHeadingText(), "Parent frame");
        nestedFramesPage.switchToNestedFrame(2);
        Assert.assertEquals(nestedFramesPage.getNestedFrameHeadingText(), "Child Iframe");
        nestedFramesPage.switchToDefaultContent();
    }
}