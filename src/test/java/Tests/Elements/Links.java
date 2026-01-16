package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class Links extends BaseTest {
	HomePage homePage;
	ElementsPage linksPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        linksPage = new ElementsPage(driver);
    }

    @Test(priority = 1, description = "TC001: Verify link Home in new tab.")
    public void testHomeLinkOpensNewTab() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnHomeLink();
        linksPage.switchToNewWindow();
        String currentUrl = linksPage.getCurrentUrl();        
        Assert.assertEquals(currentUrl, "https://demoqa.com/","The URL must contain demoqa.com");
        linksPage.closeCurrentTabAndSwitchBack();
    }
    
    @Test(priority = 2, description = "TC002: Verify dynamic link")
    public void testDynamicHomeLinkOpensNewTab() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
		String  firstNameDynamicLink = linksPage.getTextFromDynamicLink();
        linksPage.clickOnDynamicHomeLink();
        linksPage.switchToNewWindow();
        linksPage.closeCurrentTabAndSwitchBack();
        linksPage.refreshPage();
		String  secondNameDynamicLink = linksPage.getTextFromDynamicLink();
		Assert.assertNotEquals(firstNameDynamicLink, secondNameDynamicLink, String.format(" Names should be different: %s vs %s", firstNameDynamicLink, secondNameDynamicLink));	
    }
    
    @Test(priority = 3, description = "TC003: Verify Created (201) response")
    public void testCreatedLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnCreatedLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 201 and status text Created", "The text doesn't match");
    }    
        
    
    @Test(priority = 4, description = "TC004: Veriify No Content (204) response")
    public void testNoContentLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnNoContentLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 204 and status text No Content", "The text doesn't match");
    }
    
    @Test(priority = 5, description = "TC005: Verify Moved (301) response")
    public void testMovedLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnMovedLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 301 and status text Moved Permanently", "The text doesn't match");
    }
    
    @Test(priority = 6, description = "TC006: Verify Bad Request (400) response")
    public void testBadRequestLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnBadRequestLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 400 and status text Bad Request", "The text doesn't match");
    }
    
    @Test(priority = 7, description = "TC007: Verify Unauthorized (401) response")
    public void testUnauthorizedLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnUnauthorizedLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 401 and status text Unauthorized", "The text doesn't match");
    }
    
    @Test(priority = 8, description = "TC008: Verify Forbidden (403) response")
    public void testForbiddenLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnForbiddenLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 403 and status text Forbidden", "The text doesn't match");
    }
    
    @Test(priority = 9, description = "TC009: Verify Not Found (404) response")
    public void testNotFoundLinkResponse() {
        homePage.clickOnElementsLnk();
		linksPage.clickOnLinksOption();
        linksPage.clickOnNotFoundLink();
        Assert.assertEquals(linksPage.getResponseText(), "Link has responded with staus 404 and status text Not Found", "The text doesn't match");
    }
}
