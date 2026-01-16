package Tests.Forms;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.FormsPage;
import Pages.HomePage;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;
import java.util.Map;

public class PracticeForm extends BaseTest {
	HomePage homePage;
	FormsPage formsPage;
    // --- Test Data---
    private final String firstName = "Anne";
    private final String lastName = "Jones";
    private final String email = "test@example.com";
    private final String gender = "Female";
    private final String phone = "0123456789";
    private final String dateBirth= "28 May 2000";
    private final String subjects = "Biology";
    private final String hobbies = "Reading";
    private final String fileName = "chemmsmex.png";
    private final String picturePath = System.getProperty("user.dir") + File.separator + "data" + File.separator+ fileName;
    private final String address = "123 Main St, Cityville";
    private final String state = "Haryana";
    private final String city = "Karnal";

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        formsPage = new FormsPage(driver);
    }

    @Test(description = "TC001: Validate accordion expand/collapse")
	public void fillForm() {
        homePage.clickOnFormsLnk();
        formsPage.clickOnFormOption();
        formsPage.fillForm(firstName, lastName, email, phone, subjects, picturePath, address, state, city);
        formsPage.waitForModalToAppear();
        System.out.println(picturePath);
        Map<String, String> studentTable = formsPage.getModalData();
        Assert.assertEquals(studentTable.get("Student Name"), firstName + " "+ lastName, "Error: El nombre mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Student Email"), email, "Error: El email mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Gender"),gender, "Error: El genero mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Mobile"),phone, "Error: El teléfono mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Date of Birth"),dateBirth.replaceAll("\\s(\\d{4})$", ",$1"), "Error: La fecha mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Subjects"),subjects, "Error: La  materia mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Hobbies"),hobbies, "Error: El pasatiempo mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Picture"),fileName, "Error: El pasatiempo mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Address"),address, "Error: La dirrecion mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("State and City"),state + " " + city, "Error: El estado y la ciudad mostrados en el modal no coincide.");

    }

    @Test(description = "TC002: NegativeCase - Enter date birth by typing into the input.")
    public void negativeCaseFillForm() {
        homePage.clickOnFormsLnk();
        formsPage.clickOnFormOption();
        formsPage.fillFormNegative(firstName, lastName, email, phone, dateBirth, subjects, picturePath, address, state, city);
        formsPage.waitForModalToAppear();
        System.out.println(picturePath);
        Map<String, String> studentTable = formsPage.getModalData();
        Assert.assertEquals(studentTable.get("Student Name"), firstName + " "+ lastName, "Error: El nombre mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Student Email"), email, "Error: El email mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Gender"),gender, "Error: El genero mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Mobile"),phone, "Error: El teléfono mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Date of Birth"),dateBirth.replaceAll("\\s(\\d{4})$", ",$1"), "Error: La fecha mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Subjects"),subjects, "Error: La  materia mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Hobbies"),hobbies, "Error: El pasatiempo mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Picture"),fileName, "Error: El pasatiempo mostrado en el modal no coincide.");
        Assert.assertEquals(studentTable.get("Address"),address, "Error: La dirrecion mostrada en el modal no coincide.");
        Assert.assertEquals(studentTable.get("State and City"),state + " " + city, "Error: El estado y la ciudad mostrados en el modal no coincide.");

    }
}
