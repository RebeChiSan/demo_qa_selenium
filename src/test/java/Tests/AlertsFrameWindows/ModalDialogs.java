package Tests.AlertsFrameWindows;

import Pages.AlertsFramesWindowsPage;
import Pages.HomePage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogs extends BaseTest {
    HomePage homePage;
    AlertsFramesWindowsPage modalsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        modalsPage = new AlertsFramesWindowsPage(driver);
    }

    @Test(description = "TC001: Validate small modal dialog display")
    public void validateSmallModalDialogDisplay() {
        homePage.clickOnAlerts();
        modalsPage.clickOnModalDialogsOption();
        modalsPage.clickOnSmallModalButton();
        Assert.assertTrue(modalsPage.isModalDisplayed(), "Modal should be displayed");
        String modalTitle = modalsPage.getSmallModalTitle();
        Assert.assertEquals(modalTitle,"Small Modal");
        modalsPage.closeSmallModal();
    }

    @Test(description = "TC002: Validate large modal dialog display")
    public void validateLargeModalDialogDisplay() {
        homePage.clickOnAlerts();
        modalsPage.clickOnModalDialogsOption();
        modalsPage.clickOnLargeModalButton();
        Assert.assertTrue(modalsPage.isModalDisplayed(), "Modal should be displayed");
        String modalTitle = modalsPage.getLargeModalTitle();
        Assert.assertEquals(modalTitle,"Large Modal");
        modalsPage.closeLargeModal();
    }

}
