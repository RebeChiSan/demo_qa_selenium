package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    // =====================================
    // ACCORDION SECTION
    // =====================================

    @FindBy(xpath = "//span[contains(text(),'Accordian')]")
    WebElement accordionOption;

    @FindBy(id = "section1Heading")
    WebElement accordion1Heading;

    @FindBy(id = "section2Heading")
    WebElement accordion2Heading;

    @FindBy(id = "section3Heading")
    WebElement accordion3Heading;

    @FindBy(id = "section1Content")
    WebElement accordion1Content;

    @FindBy(id = "section2Content")
    WebElement accordion2Content;

    @FindBy(id = "section3Content")
    WebElement accordion3Content;

    public void clickOnAccordionOption() {
        clickWithJs(accordionOption);
    }

    public void clickOnAccordion1() {
        clickWithJs(accordion1Heading);
    }

    public void clickOnAccordion2() {
        clickWithJs(accordion2Heading);
    }

    public void clickOnAccordion3() {
        clickWithJs(accordion3Heading);
    }

    public boolean isAccordion1ContentVisible() {
            return isElementDisplayedWithWait(accordion1Content);
    }

    public boolean isAccordion2ContentVisible() {
            return isElementDisplayedWithWait(accordion2Content);
    }

    public boolean isAccordion3ContentVisible() {
            return isElementDisplayedWithWait(accordion3Content);
    }

    public String getAccordion1Content() {
        return forceGetText(accordion1Content);
    }

    public String getAccordion2Content() {
        return getText(accordion2Content);
    }

    public String getAccordion3Content() {
        return getText(accordion3Content);
    }

    // =====================================
    // DATE PICKER SECTION
    // =====================================

    @FindBy(xpath = "//span[contains(text(),'Date Picker')]")
    WebElement datePickerOption;

    @FindBy(id = "datePickerMonthYearInput")
    WebElement datePickerInput;

    @FindBy(id = "dateAndTimePickerInput")
    WebElement dateTimePickerInput;

    public void clickOnDatePickerOption() {
        clickWithJs(datePickerOption);
    }

    public void setDatePicker(String date) {
        datePickerInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        type(datePickerInput, date);
        datePickerInput.sendKeys(Keys.ENTER);
    }

    public void setDateTimePicker(String dateTime) {
        dateTimePickerInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        type(dateTimePickerInput, dateTime);
        dateTimePickerInput.sendKeys(Keys.ENTER);
    }

    public String getSelectDateText(String attribute) {
        return getAttribute(datePickerInput, attribute);
    }

    public String getSelectDateTimeText(String attribute) {
        return getAttribute(dateTimePickerInput, attribute);
    }

    // =====================================
    // TABS SECTION
    // =====================================

    @FindBy(xpath = "//span[contains(text(),'Tabs')]")
    WebElement tabsOption;

    @FindBy(xpath = "//a[@id='demo-tab-what']")
    WebElement whatTab;

    @FindBy(xpath = "//a[@id='demo-tab-origin']")
    WebElement originTab;

    @FindBy(xpath = "//a[@id='demo-tab-use']")
    WebElement useTab;

    @FindBy(xpath = "//div[@id='demo-tabpane-what']")
    WebElement whatTabContent;

    @FindBy(xpath = "//div[@id='demo-tabpane-origin']")
    WebElement originTabContent;

    @FindBy(xpath = "//div[@id='demo-tabpane-use']")
    WebElement useTabContent;

    public void clickOnTabsOption() {
        clickWithJs(tabsOption);
    }

    public void clickOnWhatTab() {
        clickWithJs(whatTab);
    }

    public void clickOnOriginTab() {
        clickWithJs(originTab);
    }

    public void clickOnUseTab() {
        clickWithJs(useTab);
    }

    public boolean isWhatTabContentDisplayed() {
        return isElementDisplayedWithWait(whatTab);
    }

    public boolean isOriginTabContentDisplayed() {
        return isElementDisplayedWithWait(originTab);
    }

    public boolean isUseTabContentDisplayed() {
        return isElementDisplayedWithWait(useTab);
    }

    public String getWhatTabContent() {
        return getText(whatTabContent);
    }

    public String getOriginTabContent() {
        return getText(originTabContent);
    }

    public String getWhatUseContent() {
        return getText(useTabContent);
    }

    // =====================================
    // TOOL TIPS SECTION
    // =====================================

    @FindBy(xpath = "//span[contains(text(),'Tool Tips')]")
    WebElement toolTipsOption;

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(id = "toolTipTextField")
    WebElement toolTipTextField;

    @FindBy(xpath = "//a[text()='Contrary']")
    WebElement toolTipLinkOne;

    @FindBy(xpath = "//a[text()='1.10.32']")
    WebElement toolTipLinkTwo;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    WebElement toolTip;

    @FindBy(id = "texToolTopContainer")
    WebElement textContainer;
    /*
    public String forceGetText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            return (String) jsExecutor.executeScript(
                    "return (arguments[0].textContent || arguments[0].innerText || '').trim();",
                    element
            );
        } catch (Exception e) {
            System.err.println("Error al obtener texto: " + e.getMessage());
            return "";
        }
    }
*/
    public void forceHover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        String script =
                "var evObj = document.createEvent('MouseEvents');" +
                        "evObj.initMouseEvent('mouseover', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                        "arguments[0].dispatchEvent(evObj);";
        jsExecutor.executeScript(script, element);
    }

    public void clickOnToolTipsOption() {
        clickWithJs(toolTipsOption);
    }

    public void hoverOverToolTipButton() {
        forceHover(toolTipButton);
    }

    public void hoverOverToolTipTextField() {
        forceHover(toolTipTextField);
    }

    public void hoverOverToolTipLinkOne() {
        forceHover(toolTipLinkOne);
    }

    public void hoverOverToolTipLinkTwo() {
        forceHover(toolTipLinkTwo);
    }

    public String getToolTipText() {
        return forceGetText(toolTip);
    }

}
