package Tests.Widgets;

import Pages.HomePage;
import Pages.WidgetsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tabs extends BaseTest {
    HomePage homePage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(description = "TC001: Validate what tab content")
    public void validateWhatTabContent() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnTabsOption();
        widgetsPage.clickOnWhatTab();
        Assert.assertTrue(widgetsPage.isWhatTabContentDisplayed(), "Home tab content should be displayed");
        String content = widgetsPage.getWhatTabContent();
        System.out.println(content);
        Assert.assertTrue(content.contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry."), "Tab content should not be null");
    }

    @Test(description = "TC002: Validate origin tab content")
    public void validateOriginTabContent() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnTabsOption();
        widgetsPage.clickOnOriginTab();
        Assert.assertTrue(widgetsPage.isOriginTabContentDisplayed(), "Home tab content should be displayed");
        String content = widgetsPage.getOriginTabContent();
        System.out.println(content);
        Assert.assertTrue(content.contains("Contrary to popular belief, Lorem Ipsum is not simply random text."), "Tab content should not be null");
    }

    @Test(description = "TC003: Validate use tab content")
    public void validateUseTabContent() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnTabsOption();
        widgetsPage.clickOnUseTab();
        Assert.assertTrue(widgetsPage.isUseTabContentDisplayed(), "Home tab content should be displayed");
        String content = widgetsPage.getWhatUseContent();
        System.out.println(content);
        Assert.assertTrue(content.contains("It is a long established fact that a reader will be distracted"), "Tab content should not be null");
    }
}
