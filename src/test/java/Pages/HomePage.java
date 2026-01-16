package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[contains(text(),'Elements')]")
    WebElement elementsLnk;

    @FindBy(xpath = "//h5[contains(text(),'Forms')]")
    WebElement formsLnk;

    @FindBy(xpath = "//h5[contains(text(),'Alerts, Frame & Windows')]")
    WebElement alertsLnk;

    @FindBy(xpath = "//h5[contains(text(),'Widgets')]")
    WebElement widgetsLnk;

    public void clickOnElementsLnk() {
        clickWithJs(elementsLnk);
    }

    public void clickOnFormsLnk() {
        clickWithJs(formsLnk);
    }

    public void clickOnAlerts() {
        clickWithJs(alertsLnk);
    }

    public void clickOnWidgets() {
        clickWithJs(widgetsLnk);
    }

}