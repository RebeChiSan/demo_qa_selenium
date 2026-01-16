package Tests.Widgets;

import Pages.FormsPage;
import Pages.HomePage;
import Pages.WidgetsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Accordion extends BaseTest {
    HomePage homePage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(description = "TC001: Validate accordion expand/collapse")
    public void validateAccordionOneExpandCollapse() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnAccordionOption();
        //widgetsPage.waitForPageLoad();
        widgetsPage.clickOnAccordion1();
        //Assert.assertTrue(widgetsPage.isAccordion1ContentVisible());
        String content = widgetsPage.getAccordion1Content();
        System.out.println(content+"viene vacio?");
        Assert.assertTrue(content.contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry."), "Accordion content should not be null");
    }

    @Test(description = "TC002: Validate accordion expand/collapse")
    public void validateAccordionTwoExpandCollapse() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnAccordionOption();
        widgetsPage.clickOnAccordion2();
        //Assert.assertTrue(widgetsPage.isAccordion2ContentVisible());
        String content = widgetsPage.getAccordion2Content();
        Assert.assertTrue(content.contains("Contrary to popular belief, Lorem Ipsum is not simply random text."), "Accordion content should not be null");
    }

    @Test(description = "TC003: Validate accordion expand/collapse")
    public void validateAccordionThreeExpandCollapse() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnAccordionOption();
        widgetsPage.clickOnAccordion3();
        //Assert.assertTrue(widgetsPage.isAccordion3ContentVisible());
        String content = widgetsPage.getAccordion3Content();
        Assert.assertTrue(content.contains("It is a long established fact that a reader"), "Accordion content should not be null");
    }
}
