package Tests.AlertsFrameWindows;

import Pages.FormsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AlertsFramesWindowsPage;
import Pages.HomePage;

public class Alerts extends BaseTest {
	HomePage homePage;
	AlertsFramesWindowsPage alertsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        alertsPage = new AlertsFramesWindowsPage(driver);

    }

	@Test(description = "TC001: Validate simple alert handling")
	public void handleSimpleAlert() {
        homePage.clickOnAlerts();
		alertsPage.clickOnAlertsOption();
		alertsPage.clickOnAlertButton();
        String result = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		Assert.assertEquals(result, "You clicked a button");
	}

	@Test(description = "TC002: Validate delayed alert handling")
	public void handleDelayedAlert() {
        homePage.clickOnAlerts();
		alertsPage.clickOnAlertsOption();
        alertsPage.clickOnDelayedAlertButton();
        alertsPage.sleep(6000);
        String result = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		Assert.assertEquals(result, "This alert appeared after 5 seconds");
	}

	@Test(description = "TC003: Validate confirm alert - Accept")
	public void handleConfirmAlertAccept() {
        homePage.clickOnAlerts();
		alertsPage.clickOnAlertsOption();
        alertsPage.clickOnConfirmButton();
        String result = alertsPage.getAlertText();
        alertsPage.acceptAlert();
		Assert.assertEquals(result, "Do you confirm action?");
        Assert.assertEquals(alertsPage.getConfirmAlertText(),"You selected Ok");

	}

	@Test(description = "TC004: Validate confirm alert - Cancel")
	public void handleConfirmAlertCancel() {
        homePage.clickOnAlerts();
		alertsPage.clickOnAlertsOption();
        alertsPage.clickOnConfirmButton();
        String result = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        Assert.assertEquals(result, "Do you confirm action?");
        Assert.assertEquals(alertsPage.getConfirmAlertText(),"You selected Cancel");
	}

	@Test(description = "TC005: Validate prompt alert with input")
	public void handlePromptAlert() {
        homePage.clickOnAlerts();
		alertsPage.clickOnAlertsOption();
		alertsPage.clickOnPromptButton();
		alertsPage.typeInAlert("QA Test");
		String result = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        Assert.assertEquals(result, "Please enter your name");
        Assert.assertEquals(alertsPage.getPromptAlertText(),"You entered QA Test");
	}
}

