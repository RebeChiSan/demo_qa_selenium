package Tests.Widgets;

import Pages.HomePage;
import Pages.WidgetsPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker extends BaseTest {
    HomePage homePage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(description = "TC001: Validate date picker")
    public void validateDatePicker() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnDatePickerOption();
        widgetsPage.setDatePicker("12/25/2025");
        Assert.assertEquals(widgetsPage.getSelectDateText("value"), "12/25/2025");
    }

    @Test(description = "TC002: Validate date and time picker")
    public void validateDateTimePicker() {
        homePage.clickOnWidgets();
        widgetsPage.clickOnDatePickerOption();
        widgetsPage.setDateTimePicker("May 23, 2026 8:15 PM");
        Assert.assertEquals(widgetsPage.getSelectDateTimeText("value"), "May 23, 2026 8:15 PM");
    }
}
