package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class DynamicProperties extends BaseTest {
	HomePage homePage;
	ElementsPage dynamicPropertiesPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        dynamicPropertiesPage  = new ElementsPage(driver);
    }

	@Test(description = "TC001: Verify text with dynamic ID")
	public void testRandomId() {
        homePage.clickOnElementsLnk();
		dynamicPropertiesPage.clickOnDynamicPropertiesOption();
		String idOne= dynamicPropertiesPage.getRandomIdAttribute();
		dynamicPropertiesPage.refreshPage();
		dynamicPropertiesPage.sleep(2000);
		String idTwo= dynamicPropertiesPage.getRandomIdAttribute();
		Assert.assertNotEquals(idOne, idTwo, String.format(" IDs should be different: %s vs %s", idOne, idTwo));	
		System.out.println("✓ TC-002 PASSED: ID dinámico funciona correctamente");
	    System.out.println("  Primer ID: " + idOne);
	    System.out.println("  Segundo ID: " + idTwo);	
	}
	
	@Test(description ="TC002: Verify the ‘Enable After 5 seconds’ button.")
	public void testButtonEnable() {
        homePage.clickOnElementsLnk();
		dynamicPropertiesPage.clickOnDynamicPropertiesOption();
        long startTime = System.currentTimeMillis();
        Assert.assertFalse(dynamicPropertiesPage.isEnableButtonEnabled(),  "The button should be disabled initially."); 
        dynamicPropertiesPage.waitForEnableButton();
        Assert.assertTrue(dynamicPropertiesPage.isEnableButtonEnabled(),  "The button should be enabled.");
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println(elapsedTime);
        Assert.assertTrue(elapsedTime >= 4 && elapsedTime <= 6, String.format("The button was enabled in %d seconds, expected ~5s.", elapsedTime));
	}

	@Test(description = "TC003: Verify button color change.")
	public void testVerifyColorChange() {
        homePage.clickOnElementsLnk();
		dynamicPropertiesPage.clickOnDynamicPropertiesOption();
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(dynamicPropertiesPage.getButtonClass(), "mt-4 btn btn-primary");
        dynamicPropertiesPage.waitForClassChange();
        Assert.assertEquals(dynamicPropertiesPage.getButtonClass(), "mt-4 text-danger btn btn-primary");
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println(elapsedTime);
	}

	@Test(description = "TC004: Verify button visibility.")
	public void testVerifyVisibilityChange() {
        homePage.clickOnElementsLnk();
		dynamicPropertiesPage.clickOnDynamicPropertiesOption();
        long startTime = System.currentTimeMillis();
        dynamicPropertiesPage.waitForVisibleButton();
        Assert.assertTrue(dynamicPropertiesPage.isVisibleButtonDisplayed());
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println(elapsedTime);
	}
	
	
}
