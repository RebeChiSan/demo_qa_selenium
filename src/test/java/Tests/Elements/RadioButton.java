package Tests.Elements;


import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class RadioButton extends BaseTest {
	HomePage homePage;
	ElementsPage radioButtonPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        radioButtonPage = new ElementsPage(driver);
    }

	@Test(description = "TC001: Validate the results when a radio button is selected")
	public void checkRadioButtons() {
        homePage.clickOnElementsLnk();
		radioButtonPage.clickOnRadioButtonOption();
		radioButtonPage.clickOnYes();
		Assert.assertEquals(radioButtonPage.getResultRadioButton(),"Yes" , "The text doesn't match.");
		radioButtonPage.clickOnImpressive();		
		Assert.assertEquals(radioButtonPage.getResultRadioButton(),"Impressive" , "The text doesn't match.");
		Assert.assertFalse(radioButtonPage.isNoRadioButtonEnabled(), "The element is enabled");
		
	}
}
