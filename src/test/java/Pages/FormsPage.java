package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormsPage extends BasePage {
	
	public FormsPage(WebDriver driver) {
        super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Practice Form')]")
	WebElement formOption;
	
	@FindBy(id = "firstName")
	WebElement firstNameInput;
	
	@FindBy(id= "lastName")
	WebElement lastNameInput;
	
	@FindBy(id= "userEmail")
	WebElement emailInput;
	
	@FindBy(xpath = "//label[text()='Female']")
	WebElement femaleRadio;
	
	@FindBy(id = "userNumber")
	WebElement phoneNumber;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(xpath= "//label[text()='Reading']")
    WebElement readingCheckbox;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    WebElement stateDropdown;

    @FindBy(id = "react-select-4-input")
    WebElement cityDropdown;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(css = ".modal-content")
    WebElement submissionModal;

    @FindBy(xpath = "(//div[text()='Biology'])[2]")
    WebElement biologySubject;

    @FindBy(xpath = "(//div[text()='Haryana'])[2]")
    WebElement stateOption;

    @FindBy(xpath = "(//div[text()='Karnal'])[2]")
    WebElement cityOption;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureInput;

    @FindBy(css = "tbody tr")
    List<WebElement> modalRows;

    @FindBy(className = "react-datepicker__year-select")
    WebElement selectYear;

    @FindBy(className = "react-datepicker__month-select")
    WebElement selectMonth;

    public void clickOnFormOption() {
        scrollToElement(formOption);
		clickWithJs(formOption);
	}

    public void setDateInput(String date) {
        dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE ));
        typeSlowly(dateOfBirthInput, date);
    }

    public void waitForModalToAppear() {
        waitForElementVisible(submissionModal);
    }

    public void setDatePicker( String day, String monthValue, String yearValue) {
        clickWithJs(dateOfBirthInput);
        Select yearDropdown = new Select(selectYear);
        yearDropdown.selectByValue(yearValue);
        Select monthDropdown = new Select(selectMonth);
        monthDropdown.selectByValue(monthValue);
        String formattedDay = String.format("%03d", Integer.parseInt(day)); // Convierte "16" en "016"

        String daySelector = String.format(
                ".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)",
                formattedDay
        );
        WebElement dayElement = driver.findElement(By.cssSelector(daySelector));
        executeJS("arguments[0].click();", dayElement);
    }
	
	public void fillForm( String firstName, String lastName, String email , String phone, String subjects, String picturePath, String address, String state, String city) {
		scrollToElement(firstNameInput);
        type(firstNameInput, firstName);
        scrollToElement(lastNameInput);
		type(lastNameInput, lastName);
        scrollToElement(emailInput);
        type(emailInput, email);
        scrollToElement(femaleRadio);
        clickWithJs(femaleRadio);
        scrollToElement(phoneNumber);
		type(phoneNumber, phone);
        scrollToElement(dateOfBirthInput);
        setDatePicker("28", "4", "2000" );
        typeSlowly(subjectsInput,subjects);
        scrollToElement(biologySubject);
        clickWithJs(biologySubject);
        scrollToElement(readingCheckbox);
        clickWithJs(readingCheckbox);
        type(uploadPictureInput, picturePath);
        scrollToElement(currentAddressInput);
        type(currentAddressInput, address);
        typeSlowly(stateDropdown, state);
        scrollToElement(stateOption);
        clickWithJs(stateOption);
        typeSlowly(cityDropdown, city);
        scrollToElement(cityDropdown);
        clickWithJs(cityOption);
        scrollToElement(submitButton);
        clickWithJs(submitButton);
    }

    public void fillFormNegative( String firstName, String lastName, String email , String phone,String dateBirth, String subjects, String picturePath, String address, String state, String city) {
        scrollToElement(firstNameInput);
        type(firstNameInput, firstName);
        scrollToElement(lastNameInput);
        type(lastNameInput, lastName);
        scrollToElement(emailInput);
        type(emailInput, email);
        scrollToElement(femaleRadio);
        clickWithJs(femaleRadio);
        scrollToElement(phoneNumber);
        type(phoneNumber, phone);
        scrollToElement(dateOfBirthInput);
        setDateInput(dateBirth);
        typeSlowly(subjectsInput,subjects);
        scrollToElement(biologySubject);
        clickWithJs(biologySubject);
        scrollToElement(readingCheckbox);
        clickWithJs(readingCheckbox);
        type(uploadPictureInput, picturePath);
        scrollToElement(currentAddressInput);
        type(currentAddressInput, address);
        typeSlowly(stateDropdown, state);
        scrollToElement(stateOption);
        clickWithJs(stateOption);
        typeSlowly(cityDropdown, city);
        scrollToElement(cityDropdown);
        clickWithJs(cityOption);
        scrollToElement(submitButton);
        clickWithJs(submitButton);
    }

    public Map<String, String> getModalData() {
        Map<String, String> modalData = new HashMap<>();

        for (WebElement row : modalRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() == 2) {
                String label = columns.get(0).getText().trim();
                String value = columns.get(1).getText().trim();
                modalData.put(label, value);
            }
        }
        return modalData;
    }

}
