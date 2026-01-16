package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFramesWindowsPage extends BasePage {

	public AlertsFramesWindowsPage(WebDriver driver) {
        super(driver);
	}

	// =====================================
	// ALERTS SECTION
	// =====================================

	@FindBy(xpath = "//span[contains(text(),'Alerts')]")
	WebElement alertsOption;

	@FindBy(id = "alertButton")
	WebElement alertBtn;

	@FindBy(id = "timerAlertButton")
	WebElement delayedAlertBtn;

	@FindBy(id = "confirmButton")
	WebElement confirmAlertBtn;

	@FindBy(id = "promtButton")
	WebElement promptAlertBtn;

    public void clickOnAlertsOption() {
        clickWithJs(alertsOption);
    }

    public void clickOnAlertButton() {
        clickWithJs(alertBtn);
    }

    public void clickOnDelayedAlertButton() {
        clickWithJs(delayedAlertBtn);
    }

    public void clickOnConfirmButton() {
        clickWithJs(confirmAlertBtn);
    }

    public void clickOnPromptButton() {
        clickWithJs(promptAlertBtn);
    }

    public String getConfirmAlertText(){
        return getText(confirmResult);
    }

    public String getPromptAlertText(){
        return getText(promptResult);
    }

    // =====================================
	// BROWSER WINDOWS SECTION
	// =====================================

	@FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
	WebElement browserWindowsOption;

	@FindBy(id = "windowButton")
	WebElement newWindowBtn;

	@FindBy(id = "messageWindowButton")
	WebElement newMessageWindowBtn;

	@FindBy(id = "tabButton")
	WebElement newTabBtn;

    public void clickOnBrowserWindowsOption() {
        clickWithJs(browserWindowsOption);
    }

    public void clickOnNewTabButton() {
        clickWithJs(newTabBtn);
    }

    public void clickOnNewWindowButton() {
        clickWithJs(newWindowBtn);
    }

    public void clickOnNewMessageWindowButton() {
        clickWithJs(newMessageWindowBtn);
    }

    public String getNewWindowMessage() {
        return getText(textMessage);
    }

    // =====================================
	// FRAMES SECTION
	// =====================================

	@FindBy(xpath = "//span[contains(text(),'Frames')]")
	WebElement framesOption;

	@FindBy(id = "frame1")
	WebElement frame1;

	@FindBy(id = "frame2")
	WebElement frame2;

	@FindBy(xpath = "//h1[@id='sampleHeading']")
	WebElement frameHeading;

    public void clickOnFramesOption() {
        clickWithJs(framesOption);
    }

    public void switchToFrameNumber(int frameNumber) {
        if (frameNumber == 1) {
            switchToFrame(frame1);
        } else if (frameNumber == 2) {
            switchToFrame(frame2);
        }
    }

    public String getFrameHeadingText() {
        return getText(frameHeading);
    }

    // =====================================
    // NESTED FRAMES SECTION
    // =====================================
    @FindBy(xpath = "//span[contains(text(),'Nested Frames')]")
    WebElement nestedFramesOption;

    @FindBy(id = "frame1")
    WebElement parentFrame;

    @FindBy(xpath = "//body")
    WebElement headingText;

    @FindBy(xpath ="//iframe[contains(@srcdoc, 'Child Iframe')]")
    WebElement childFrame;

    public void clickOnNestedFrames(){
        clickWithJs(nestedFramesOption);
    }

    public void switchToNestedFrame(int frameNumber) {
        if (frameNumber == 1) {
            switchToFrame(parentFrame);
        } else if (frameNumber == 2) {
            switchToFrame(childFrame);
        }
    }

    public String getNestedFrameHeadingText() {
        return getText(headingText);
    }

    // =====================================
	// MODAL DIALOGS SECTION
	// =====================================

	@FindBy(xpath = "//span[contains(text(),'Modal Dialogs')]")
	WebElement modalDialogsOption;

	@FindBy(id = "showSmallModal")
	WebElement smallModalBtn;

	@FindBy(id = "showLargeModal")
	WebElement largeModalBtn;

	@FindBy(id = "closeSmallModal")
	WebElement smallModalCloseBtn;

    @FindBy(id = "closeLargeModal")
    WebElement largeModalCloseBtn;

	@FindBy(className = "modal-content")
	WebElement modalContent;

    @FindBy(id = "example-modal-sizes-title-sm")
    WebElement smallModalTitle;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement largeModalTitle;

    @FindBy(xpath = "body")
    WebElement textMessage;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    @FindBy(id = "promptResult")
    WebElement promptResult;

	public void clickOnModalDialogsOption() {
		clickWithJs(modalDialogsOption);
	}

	public void clickOnSmallModalButton() {
		clickWithJs(smallModalBtn);
	}

	public void clickOnLargeModalButton() {
        clickWithJs(largeModalBtn);
	}

	public void closeSmallModal() {
        clickWithJs(smallModalCloseBtn);
	}

    public void closeLargeModal() {
        clickWithJs(largeModalCloseBtn);
    }

    public String getSmallModalTitle() {
        return getText(smallModalTitle);
	}

    public String getLargeModalTitle() {
        return getText(largeModalTitle);
    }

    public boolean isModalDisplayed() {
        return isElementDisplayedWithWait(modalContent);
	}

}
