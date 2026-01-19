package Tests.Elements;

import Pages.AlertsFramesWindowsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class BrokenLinksImages extends BaseTest {
	HomePage homePage;
	ElementsPage brokenLinksPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        brokenLinksPage = new ElementsPage(driver);
    }
    //fail
	@Test(description = "Verificar link válido y su funcionamiento")
	public void verifyValidLink() {
        homePage.clickOnElementsLnk();
        brokenLinksPage.clickOnBrokenLinksOption();
		String hrefLink = brokenLinksPage.getValidHref();
		Assert.assertNotNull(hrefLink, "El href del link es nulo");
		int statusCode = brokenLinksPage.getStatusCode(hrefLink);
		Assert.assertTrue(statusCode >= 200 && statusCode < 400, "El link válido debería retornar un código (2xx o 3xx)");
		brokenLinksPage.clickOnValidLink();
        Assert.assertEquals(brokenLinksPage.getCurrentUrl(), "https://demoqa.com/" , "No se navegó correctamente después de hacer clic en el link válido");
	}

    //fail
	@Test(description = "Verificar link invalido y su funcionamiento")
    public void verifyBrokenLink() {
        homePage.clickOnElementsLnk();
        brokenLinksPage.clickOnBrokenLinksOption();
        String hrefLink = brokenLinksPage.getValidHref();
        Assert.assertNotNull(hrefLink, "El href del link es nulo");
        int statusCode = brokenLinksPage.getStatusCode(hrefLink);
        Assert.assertEquals(statusCode ,statusCode >= 400 , "El link inválido debería retornar un código (4xx o 5xx)");
        brokenLinksPage.clickOnBrokenLink();
        Assert.assertEquals(brokenLinksPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500" , "No se navegó correctamente después de hacer clic en el link roto");
    }
	
	
	@Test(description = "Verificar imagen válida y su funcionamiento")
	public void verifyValidImage() {
        homePage.clickOnElementsLnk();
        brokenLinksPage.clickOnBrokenLinksOption();
		String srcImage = brokenLinksPage.getValidSrc();
        System.out.println(srcImage);
		Assert.assertNotNull(srcImage, "El href del link es nulo");
		int statusCode = brokenLinksPage.getStatusCode(srcImage);
        System.out.println(statusCode);
		Assert.assertTrue(brokenLinksPage.isValidImageDisplayed());
        Assert.assertEquals(statusCode ,200, "La imagen debería retornar un código 200");
    }
	//fail
	@Test(description = "Verificar imagen rota y su funcionamiento")
    public void verifyBrokenImage() {
        homePage.clickOnElementsLnk();
        brokenLinksPage.clickOnBrokenLinksOption();
        Assert.assertFalse(brokenLinksPage.isBrokenImageDisplayed());
        String srcImage = brokenLinksPage.getBrokenSrc();
        Assert.assertNotNull(srcImage, "El href del link es nulo");
        Assert.assertFalse(brokenLinksPage.isBrokenImageDisplayed());
        int statusCode = brokenLinksPage.getStatusCode(srcImage);
        Assert.assertFalse(brokenLinksPage.isBrokenImageDisplayed());
        Assert.assertTrue(statusCode >= 400  , "El link inválido debería retornar un código (4xx o 5xx)");
     }
	
}
