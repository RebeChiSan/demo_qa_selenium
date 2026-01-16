package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class Buttons extends BaseTest {
	HomePage homePage;
	ElementsPage buttonsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        buttonsPage  = new ElementsPage(driver);
    }
	
	@Test(description = "TC001: Validate the results when double click button is clicked")
	public void checkDoubleClick() {
        homePage.clickOnElementsLnk();
		buttonsPage.clickOnButtonsOption();
        buttonsPage.clickOnDoubleClickBtn();
		Assert.assertEquals(buttonsPage.getDoubleClickMessage(),"You have done a double click", "The text doesn't match.");
	}

    @Test(description = "TC002: Validate the results when right click button is clicked")
    public void checkRightClick() {
        homePage.clickOnElementsLnk();
        buttonsPage.clickOnButtonsOption();
        buttonsPage.clickOnRightClick();
        Assert.assertEquals(buttonsPage.getRightClickMessage(),"You have done a right click" , "The text doesn't match.");
    }

    @Test(description = "TC003: Validate the results when dynamic click button is clicked")
    public void checkDynamicClick() {
        homePage.clickOnElementsLnk();
        buttonsPage.clickOnButtonsOption();
        buttonsPage.clickOnDynamicClick();
        Assert.assertEquals(buttonsPage.getDynamicClickMessage(),"You have done a dynamic click" , "The text doesn't match.");
    }
}
