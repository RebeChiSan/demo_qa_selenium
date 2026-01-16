package Tests.Widgets;

import Pages.HomePage;
import Pages.WidgetsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTips extends BaseTest {
    HomePage homePage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(description = "TC001: Validate button tooltip")
    public void validateButtonToolTip() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnToolTipsOption();;
        widgetsPage.hoverOverToolTipButton();
        String toolTipText = widgetsPage.getToolTipText();
        Assert.assertEquals(toolTipText,"You hovered over the Button", "Tab content should not be null");
    }

    @Test(description = "TC002: Validate text tooltip")
    public void validateTextToolTip() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnToolTipsOption();;
        widgetsPage.hoverOverToolTipTextField();
        String toolTipText = widgetsPage.getToolTipText();
        Assert.assertEquals(toolTipText,"You hovered over the text field", "Tab content should not be null");
    }

    @Test(description = "TC003: Validate link one tooltip")
    public void validateLinkOneToolTip() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnToolTipsOption();;
        widgetsPage.hoverOverToolTipLinkOne();
        String toolTipText = widgetsPage.getToolTipText();
        Assert.assertEquals(toolTipText,"You hovered over the Contrary", "Tab content should not be null");
    }

    @Test(description = "TC004: Validate link two tooltip")
    public void validateLinkTwoToolTip() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnToolTipsOption();
        widgetsPage.hoverOverToolTipLinkTwo();
        String toolTipText = widgetsPage.getToolTipText();
        Assert.assertEquals(toolTipText,"You hovered over the 1.10.32", "Tab content should not be null");
    }
}
