package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import java.net.URI;
import java.net.URL;
public class ElementsPage extends BasePage {
	
	public ElementsPage(WebDriver driver) {
		super(driver);
	}

    // =====================================
    // OPTIONS
    // =====================================
	@FindBy(xpath = "//span[contains(text(),'Text Box')]")
	WebElement textBoxOption;
	
	@FindBy(xpath = "//span[contains(text(),'Check Box')]")
	WebElement checkBoxOption;
	
	@FindBy(xpath = "//span[contains(text(),'Radio Button')]")
	WebElement radioBtnOption;
	
	@FindBy(xpath = "//span[contains(text(),'Web Tables')]")
	WebElement tablesOption;
	
	@FindBy(xpath = "//span[contains(text(),'Buttons')]")
	WebElement btnsOption;
	
	@FindBy(xpath = "//span[contains(text(),'Links')]")
	WebElement lnksOption;
	
	@FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
	WebElement brokenLnksOption;
	
	@FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
	WebElement uploadDownloadOption;
	
	@FindBy(xpath = "//span[contains(text(),'Dynamic Properties')]")
	WebElement dynamicPropsOption;
	
	public void clickOnTextBoxOption() {
        clickWithJs(textBoxOption);
	}
	
	public void clickOnCheckBoxOption() {
        clickWithJs(checkBoxOption);
	}
	
	public void clickOnRadioButtonOption() {
        clickWithJs(radioBtnOption);
	}

    public void clickOnWebTablesOption() {
        clickWithJs(tablesOption);
    }

	public void clickOnButtonsOption() {
		clickWithJs(btnsOption);
	}
		
	public void clickOnLinksOption() {
		clickWithJs(lnksOption);
	}
		
	public void clickOnBrokenLinksOption() {
		clickWithJs(brokenLnksOption);
	}

	public void clickOnUploadDownloadOption() {
		clickWithJs(uploadDownloadOption);
	}

    public void clickOnDynamicPropertiesOption() {
		clickWithJs(dynamicPropsOption);
	}

    // =====================================
    // TEXT BOX
    // =====================================
	@FindBy(css = "#userName")
	WebElement fullNameInput;
	
	@FindBy(xpath = "(//input[@id='userEmail'])[1]")
	WebElement userEmailInput;
	
	@FindBy(id = "currentAddress")
	WebElement currentAddressTxtArea;
	
	@FindBy(id = "permanentAddress")
	WebElement permanentAddressTxtArea;
	
	@FindBy(id = "submit")
	WebElement submitBtn;

	@FindBy(xpath="//p[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//p[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//p[@id='currentAddress']")
	WebElement currentAddress;
	
	@FindBy(xpath="//p[@id='permanentAddress']")
	WebElement permanentAddress;

	public void fillFullName(String name) {
		scrollToElement(fullNameInput);
		type(fullNameInput, name);
	}
	
	public void fillUserEmail(String email) {
		scrollToElement(userEmailInput);
		type(userEmailInput, email);
	}
	
	public void fillCurrentAddress(String currentAddress) {
		scrollToElement(currentAddressTxtArea);
		type(currentAddressTxtArea, currentAddress);
	}
	
	public void fillPermanentAddress(String permanentAddress) {
		scrollToElement(permanentAddressTxtArea);
		type(permanentAddressTxtArea, permanentAddress);
	}
		
	public void clickOnSubmit() {
		clickWithJs(submitBtn);
	}
	
	public boolean waitForNameNotVisible() {
        return isElementNotVisible(name);
	}

	public boolean waitForEmailNotVisible() {
		return isElementNotVisible(email);
	}
	
	public boolean waitForCurrentAddressNotVisible() {
        return isElementNotVisible(currentAddress);
	}
	
	public boolean waitForPermanentAddressNotVisible() {
        return isElementNotVisible(permanentAddress);
	}
	
	public String getInputEmailClass() {
		scrollToElement(userEmailInput);
		return getAttribute(userEmailInput, "class");
	}

    public String getName() {
        return getText(name); }

    public String getEmail() {
        return getText(email);
    }

    public String getCurrentAddress() {
        return getText(currentAddress);
    }

    public String getPermanentAddress() {
        return getText(permanentAddress);
    }

    // ===================================
    // CHECK BOX
    // =====================================
	@FindBy(xpath = "//button[@title='Expand all']")
	WebElement expandAllBtn;
	
	@FindBy(xpath = "//button[@title='Collapse all']")
	WebElement collapseAllBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Desktop')]")
	WebElement desktopCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Documents')]")
	WebElement documentsCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Downloads')]")
	WebElement downloadsCheckbox;
	@FindBy(xpath = "//span[contains(text(),'React')]")
	WebElement reactCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Office')]")
	WebElement officeCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Excel File.doc')]")
	WebElement excelFileCheckbox;
	
	@FindBy(css = "#result .text-success")
	List<WebElement> result;

	public void clickOnExpandAll() {
		clickWithJs(expandAllBtn);
	}

    public void clickOnCollapseAll() {
        clickWithJs(collapseAllBtn);
    }

    public void waitForListToExpand() {
        waitForElementVisible(desktopCheckbox);
	}

	public boolean isDesktopVisible() {
		scrollToElement(desktopCheckbox);
		return isElementDisplayed(desktopCheckbox);
	}
	
	public boolean isDocumentsVisible() {
		scrollToElement(documentsCheckbox);
		return isElementDisplayed(documentsCheckbox);
	}
	
	public boolean isDownloadsVisible() {
		scrollToElement(downloadsCheckbox);
		return isElementDisplayed(downloadsCheckbox);
	}

	public boolean isDesktopNotVisible() {
        return isElementNotVisible(desktopCheckbox);
	}
	
	public boolean isDocumentsNotVisible() {
        return isElementNotVisible(documentsCheckbox);
	}
	
	public boolean isDownloadsNotVisible() {
        return isElementNotVisible(downloadsCheckbox);
	}

    public void clickOnReact() {
        clickWithJs(reactCheckbox);
    }

    public void clickOnOffice() {
        clickWithJs(officeCheckbox);
    }

    public void clickOnExcel() {
        clickWithJs(excelFileCheckbox);
    }
	
	public String getResultCheckbox() {
		StringBuilder concatenatedTxt = new StringBuilder();
		for (WebElement element : result) {
            String txtElement = element.getText().trim();
            concatenatedTxt.append(txtElement);
        }
		return concatenatedTxt.toString();
	}

    // =====================================
    // RADIO BUTTON
    // =====================================
	
	@FindBy(css = "label[for='yesRadio']")
	WebElement yesRadioBtn;
	
	@FindBy(css = "label[for='impressiveRadio']")
	WebElement impressiveRadioBtn;
	
	@FindBy(id = "noRadio")
	WebElement noRadioBtn;
	
	@FindBy(css = ".text-success")
	WebElement textResultRedioButton;
	
	public void clickOnYes() {
        clickWithJs(yesRadioBtn);
	}
	
	public void clickOnImpressive() {
		clickWithJs(impressiveRadioBtn);
	}

	public String getResultRadioButton() {
        return getText(textResultRedioButton);
	}
	
	public boolean isNoRadioButtonEnabled() {
        return isElementEnabled(noRadioBtn);
	}

	// =====================================
    // WEB TABLES
    // =====================================
	@FindBy(id = "searchBox")
	WebElement searchBox;
	
	@FindBy(id = "addNewRecordButton")
	WebElement addBtn;
	
	@FindBy(id = "firstName")
	WebElement firstNameInput;

	@FindBy(id = "lastName")
	WebElement lastNameInput;

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "age")
	WebElement ageInput;

	@FindBy(id = "salary")
	WebElement salaryInput;

	@FindBy(id = "department")
	WebElement departmentInput;
	
	@FindBy(id = "submit")
	WebElement submitFormBtn;

	@FindBy(xpath = "//div[@role='row']//span[@title='Edit']")
	List<WebElement> editButtons;

	@FindBy(xpath = "//div[@role='row']//span[@title='Delete']")
	List<WebElement> deleteButtons;

	@FindBy(xpath = "//div[@role='row']")
	List<WebElement> tableRows;

	public void searchInTable(String searchText) {
		scrollToElement(searchBox);
		type(searchBox, searchText);
	}

	public void clickOnAddNewRecordButton() {
		clickWithJs(addBtn);
	}

	public void fillNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
		scrollToElement(firstNameInput);
        type(firstNameInput, firstName);
		type(lastNameInput, lastName);
		type(userEmail, email);
		type(ageInput, age);
		type(salaryInput, salary);
		type(departmentInput, department);
		clickWithJs(submitFormBtn);
	}

	public void editRecord(int recordNumber, String firstName, String lastName, String email, String age, String salary, String department) {
		if (recordNumber - 1 < editButtons.size()) {
            scrollToElement(editButtons.get(recordNumber - 1));
			clickWithJs(editButtons.get(recordNumber - 1));
			type(firstNameInput, firstName);
			type(lastNameInput, lastName);
			type(userEmail, email);
			type(ageInput, age);
			type(salaryInput, salary);
			type(departmentInput, department);
			clickWithJs(submitFormBtn);
		}
	}

	public void deleteRecord(int recordNumber) {
        scrollToElement(deleteButtons.get(recordNumber - 1));
		if (recordNumber - 1 < deleteButtons.size()) {
			clickWithJs(deleteButtons.get(recordNumber - 1));
		}
	}

	public int getTableRowsCount() {
		return editButtons.size();
	}

	public String getTableRowContent(int rowNumber) {
		if (rowNumber - 1 < tableRows.size()) {
			return getText(tableRows.get(rowNumber - 1));
		}
		return "";
	}

	// =====================================
    //  BUTTONS
    // =====================================
	@FindBy(css = "#doubleClickBtn")
	WebElement doubleClickBtn;
	
	@FindBy(css = "#rightClickBtn")
	WebElement rightClickBtn;
	
	@FindBy(xpath = "//button[text()='Click Me']")
	WebElement clickBtn;
	
	@FindBy(id = "doubleClickMessage")
	WebElement doubleClickMessage;
	
	@FindBy(id = "rightClickMessage")
	WebElement rightClickMessage;
	
	@FindBy(id = "dynamicClickMessage")
	WebElement clickMessage;
	
	public void clickOnDoubleClickBtn() {
        String script =
                "var ev = new MouseEvent('dblclick', { 'bubbles': true, 'cancelable': true });" +
                        "arguments[0].dispatchEvent(ev);";

        executeJS(script, doubleClickBtn);
	}
	
	public void clickOnRightClick() {
        String script =
                "var ev = new MouseEvent('contextmenu', { " +
                        "  'bubbles': true, " +
                        "  'cancelable': true, " +
                        "  'button': 2, " +
                        "  'buttons': 2 " +
                        "});" +
                        "arguments[0].dispatchEvent(ev);";
        executeJS(script, rightClickBtn);
	}
	
	public void clickOnDynamicClick() {
		clickWithJs(clickBtn);
	}
	
	public String getDoubleClickMessage () {
        scrollToElement(doubleClickMessage);
        return forceGetText(doubleClickMessage);
    }
	
	public String getRightClickMessage () {
        scrollToElement(rightClickMessage);
        return forceGetText(rightClickMessage);
	}
	
	public String getDynamicClickMessage () {
        scrollToElement(clickMessage);
        return forceGetText(clickMessage);
	}

	// =====================================
    // LINKS
    // =====================================
	@FindBy(id = "linkResponse")
	WebElement linkResponse;

	@FindBy(id = "simpleLink")
	WebElement simpleLink;
	
	@FindBy(id = "dynamicLink")
	WebElement dynamicLink;

	@FindBy(id = "created")
	WebElement createdLink;

	@FindBy(id = "no-content")
	WebElement noContentLink;
	
	@FindBy(id = "moved")
	WebElement movedLink;
	
	@FindBy(id = "bad-request")
	WebElement badRequestLink;
	
	@FindBy(id = "unauthorized")
	WebElement unauthorizedLink;
	
	@FindBy(id = "forbidden")
	WebElement forbiddenLink;
	
	@FindBy(id = "invalid-url")
	WebElement invalidUrlLink;
	
    public void clickOnHomeLink() {
        clickWithJs(simpleLink);
    }
    
    public void clickOnDynamicHomeLink() {
        clickWithJs(dynamicLink);
    }
    
    public void clickOnCreatedLink() {
        clickWithJs(createdLink);
    }
    
    public void clickOnNoContentLink() {
        clickWithJs(noContentLink);
    }
    
    public void clickOnMovedLink() {
        clickWithJs(movedLink);
    }
    
    public void clickOnBadRequestLink() {
        clickWithJs(badRequestLink);
    }
    
    public void clickOnUnauthorizedLink() {
        clickWithJs(unauthorizedLink);
    }
    
    public void clickOnForbiddenLink() {
        clickWithJs(forbiddenLink);
    }
    
    public void clickOnNotFoundLink() {
        clickWithJs(invalidUrlLink);
    }
    
    public String getTextFromDynamicLink() {
        return getText(dynamicLink);
    }

    public String getResponseText() {
    	scrollToElement(linkResponse);
        return getText(linkResponse);
    }

	// ====================================
    // BROKEN LINKS - IMAGES
    // =====================================
    @FindBy(xpath = "//img[contains(@src, '/images/Toolsqa.jpg')]")
	WebElement validImage;
	
	@FindBy(xpath = "//img[contains(@src, '/images/Toolsqa_1.jpg')]")
	WebElement brokenImage;
	
	@FindBy( linkText =  "Click Here for Valid Link")
	WebElement validLink;
	
	@FindBy(linkText = "Click Here for Broken Link")
	WebElement brokenLink;

    public String getValidHref() {
        return getAttribute(validLink, "href");
	}

    public String getBrokenHref() {
        return getAttribute(brokenLink, "href");
	}

    public String getValidSrc() {
        return getAttribute(validImage, "src");
	}

    public String getBrokenSrc() {
		return getAttribute(brokenImage, "src");
	} 
	
	public int getStatusCode(String linkUrl) {
	    HttpURLConnection connection = null;
	    try {
	        URI uri = new URI(linkUrl);
	        URL url = uri.toURL();
	        connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        return connection.getResponseCode();
	    } catch (Exception e) {
	        return 500;
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	        }
	    }
	}
	
	public void clickOnValidLink() {
		clickWithJs(validLink);
	}
	
	public void clickOnBrokenLink() {
		clickWithJs(brokenLink);
	}

	public boolean isValidImageDisplayed() {
        return (boolean) executeJS(
            "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;",
            validImage);
	}

    public boolean isBrokenImageDisplayed() {
        return (boolean) executeJS(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;",
                brokenImage);
    }

	// =====================================
    // UPLOAD AND DOWNLOAD
    // =====================================
	@FindBy(id = "downloadButton")
	WebElement downloadBtn;
	
	@FindBy(id = "uploadFile")
	WebElement uploadFile;
	
	@FindBy(id = "uploadedFilePath")
	WebElement uploadedFilePath;

    public void clickOnDownloadButton() {
        scrollToElement(downloadBtn);
        clickWithJs(downloadBtn);
    }

	public void uploadFile(String filePath) {
        uploadFile.sendKeys(filePath);
	}

	public String getUploadedFilePath() {
		return getText(uploadedFilePath);
	}

	public boolean isUploadedFilePathDisplayed() {
			return isElementDisplayedWithWait(uploadedFilePath);
	}

	// =====================================
    // DYNAMIC PROPERTIES
    // =====================================
	@FindBy(id = "enableAfter")
	WebElement enableBtn;
	
	@FindBy(id = "colorChange")
	WebElement colorBtn;
	
	@FindBy(id = "visibleAfter")
	WebElement visibleBtn;
	
	@FindBy(xpath = "//p[contains(text(), 'This text has random Id')]")
	WebElement randomIdText;

    public String getRandomIdAttribute() {
        return getAttribute(randomIdText,"id");
    }
     
    public boolean isEnableButtonEnabled() {
        return isElementEnabled(enableBtn);
    }
   
    public void waitForEnableButton() {
    	waitForElementClickable(enableBtn);
    }
    
    public String getButtonClass() {
        return getAttribute(colorBtn, "class");
    }

    public void waitForClassChange() {
        waitForClassChange(colorBtn, "mt-4 text-danger btn btn-primary", 6);
    }

    public void waitForVisibleButton() {
        waitForElementVisible(visibleBtn);
    }
   
    public boolean isVisibleButtonDisplayed() {
        return isElementDisplayed(visibleBtn);
    }

}
