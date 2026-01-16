package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.ElementsPage;
import Pages.HomePage;
import Utilities.ReadExcel;
public class Textbox extends BaseTest {
		HomePage homePage;
        ElementsPage textBoxPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        textBoxPage = new ElementsPage(driver);
    }

    @DataProvider(name = "Invalid Email")
    public Object[][] getExcelData1() throws Exception{
        String fileDir = "..\\DemoQA\\data\\";
        String fileName = "TestData.xlsx";
        String sheetName = "invalid_emails";
			
        return ReadExcel.getCellValue(fileDir + fileName, sheetName);
    }
		
    @DataProvider(name = "Valid Email")
    public Object[][] getExcelData2() throws Exception{
        String fileDir = "..\\DemoQA\\data\\";
        String fileName = "TestData.xlsx";
        String sheetName = "valid_emails";
			
        return ReadExcel.getCellValue(fileDir + fileName, sheetName);
    }
		
    @Test(description = "TC001: Validate unsuccessful registration with a invalid email address.", dataProvider = "Invalid Email")
    public void fillFormWithInvalidEmail(String fullName, String email, String current , String permanent) {
        homePage.clickOnElementsLnk();
        textBoxPage.clickOnTextBoxOption();
        textBoxPage.fillFullName(fullName);
        textBoxPage.fillUserEmail(email);
        textBoxPage.fillCurrentAddress(current);
        textBoxPage.fillPermanentAddress(permanent);
        textBoxPage.clickOnSubmit();
        Assert.assertTrue(textBoxPage.getInputEmailClass().contains("field-error"));
        Assert.assertTrue(textBoxPage.waitForNameNotVisible() , "The element is visible.");
        Assert.assertTrue(textBoxPage.waitForEmailNotVisible() , "The element is visible.");
        Assert.assertTrue(textBoxPage.waitForCurrentAddressNotVisible() , "The element is visible.");
        Assert.assertTrue(textBoxPage.waitForPermanentAddressNotVisible() , "The element is visible.");
    }
		
    @Test(description = "TC002: Validate successful registration with a valid email address.", dataProvider = "Valid Email")
    public void fillFormWithValidEmail(String fullName, String email, String current , String permanent) {
        homePage.clickOnElementsLnk();
        textBoxPage.clickOnTextBoxOption();
        textBoxPage.fillFullName(fullName);
        textBoxPage.fillUserEmail(email);
        textBoxPage.fillCurrentAddress(current);
        textBoxPage.fillPermanentAddress(permanent);
        textBoxPage.clickOnSubmit();
        Assert.assertEquals(textBoxPage.getName(),"Name:"+ fullName,"El nombre no se reflejó correctamente en el formulario");
        Assert.assertEquals(textBoxPage.getEmail(),"Email:"+email,"El email no se reflejó correctamente en el formulario");
        Assert.assertEquals(textBoxPage.getCurrentAddress(),"Current Address :"+current,"La dirección actual no se reflejó correctamente");
        Assert.assertEquals(textBoxPage.getPermanentAddress(),"Permanent Address :"+permanent,"La dirección permanente no se reflejó correctamente");
    }
} 