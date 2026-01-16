package Tests.AlertsFrameWindows;

import Pages.AlertsFramesWindowsPage;
import Pages.HomePage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindows extends BaseTest {
    HomePage homePage;
    AlertsFramesWindowsPage alertsFramesWindowsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        alertsFramesWindowsPage = new AlertsFramesWindowsPage(driver);
    }

    @Test(description = "TC001: Validate new tab opening")
    public void validateNewTab() {
        homePage.clickOnAlerts();
        alertsFramesWindowsPage.clickOnBrowserWindowsOption();
        String mainWindowHandle = driver.getWindowHandle();
        alertsFramesWindowsPage.clickOnNewTabButton();
        alertsFramesWindowsPage.switchToNewWindow();
        String newTabHandle = driver.getWindowHandle();
        Assert.assertNotEquals(newTabHandle, mainWindowHandle, "New tab should have different handle");
        Assert.assertEquals(alertsFramesWindowsPage.getCurrentUrl(),"https://demoqa.com/sample");
        alertsFramesWindowsPage.switchToNewWindow();

    }

    @Test(description = "TC002: Validate new window opening")
    public void validateNewWindow() {
        homePage.clickOnAlerts();
        alertsFramesWindowsPage.clickOnBrowserWindowsOption();
        String mainWindowHandle = driver.getWindowHandle();
        alertsFramesWindowsPage.clickOnNewWindowButton();
        alertsFramesWindowsPage.switchToNewWindow();
        String newTabHandle = driver.getWindowHandle();
        Assert.assertNotEquals(newTabHandle, mainWindowHandle, "New tab should have different handle");
        Assert.assertEquals(alertsFramesWindowsPage.getCurrentUrl(),"https://demoqa.com/sample");
        alertsFramesWindowsPage.switchToNewWindow();

    }
    /*
    @Test(description = "TC003: Validate new window message")
    public void validateNewWindowMessage() {
        homePage.clickOnAlerts();
        alertsFramesWindowsPage.clickOnBrowserWindowsOption();
        alertsFramesWindowsPage.removeAds();
        String mainWindowHandle = driver.getWindowHandle();
        alertsFramesWindowsPage.clickOnNewMessageWindowButton();
        alertsFramesWindowsPage.switchToNewWindow();
        String newTabHandle = driver.getWindowHandle();
        Assert.assertNotEquals(newTabHandle, mainWindowHandle, "New tab should have different handle");
        Assert.assertEquals(alertsFramesWindowsPage.getNewWindowMessage(),"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        alertsFramesWindowsPage.switchToNewWindow();
    }
    */
}
