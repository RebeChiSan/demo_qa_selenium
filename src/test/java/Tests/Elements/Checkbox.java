package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.ElementsPage;
import Pages.HomePage;

public class Checkbox extends BaseTest {
	HomePage homePage;
	ElementsPage checkBoxPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        checkBoxPage  = new ElementsPage(driver);
    }
	
	@Test(description = "TC001: Validate Expand and collapse the home folder using the “Expand All” and “Collapse All” buttons.")
	public void expandAllCollapsewithToggle() {
        homePage.clickOnElementsLnk();
		checkBoxPage.clickOnCheckBoxOption();
        checkBoxPage.clickOnExpandAll();
		checkBoxPage.waitForListToExpand();
		Assert.assertTrue(checkBoxPage.isDesktopVisible(), "The element is not visible.");
		Assert.assertTrue(checkBoxPage.isDocumentsVisible() , "The element is not visible.");
		Assert.assertTrue(checkBoxPage.isDownloadsVisible() , "The element is not visible.");
		checkBoxPage.clickOnCollapseAll();
		Assert.assertTrue(checkBoxPage.isDesktopNotVisible(), "The element is visible.");
		Assert.assertTrue(checkBoxPage.isDocumentsNotVisible() , "The element is visible.");
		Assert.assertTrue(checkBoxPage.isDownloadsNotVisible() , "The element is visible.");
	}
	/// /fail
	@Test(description = "TC002: Validate that the checkboxes are selected and the indicated text is displayed.")
	public void selectCheckboxes() {
        homePage.clickOnElementsLnk();
		checkBoxPage.clickOnCheckBoxOption();
        checkBoxPage.clickOnExpandAll();
		checkBoxPage.waitForListToExpand();
		checkBoxPage.clickOnReact();
		checkBoxPage.clickOnOffice();
		checkBoxPage.clickOnExcel();
		Assert.assertEquals(checkBoxPage.getResultCheckbox(), "reactofficepublicprivateclassifiedgeneralexcelFile");
	}
}
