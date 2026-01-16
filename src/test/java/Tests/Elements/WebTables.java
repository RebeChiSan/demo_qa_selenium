package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ElementsPage;
import Pages.HomePage;

public class WebTables extends BaseTest {
	HomePage homePage;
	ElementsPage webTablesPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        webTablesPage = new ElementsPage(driver);
    }

	@Test(description = "TC001: Validate adding new record to web table")
	public void validateAddNewRecord() {
        homePage.clickOnElementsLnk();
		webTablesPage.clickOnWebTablesOption();
        webTablesPage.clickOnAddNewRecordButton();
        webTablesPage.fillNewRecord("John", "Doe", "john.doe@example.com", "30", "5000", "Engineering");
        webTablesPage.searchInTable("Doe");
        webTablesPage.sleep(3000);
        int rowCount = webTablesPage.getTableRowsCount();
        Assert.assertTrue(rowCount > 0, "Table should display at least one row");
        System.out.println(webTablesPage.getTableRowContent(rowCount+1)+"\ncontenido");
        Assert.assertEquals(webTablesPage.getTableRowContent(rowCount+1),"John\n" +
                "Doe\n" +
                "30\n" +
                "john.doe@example.com\n" +
                "5000\n" +
                "Engineering");
	}

	@Test(description = "TC002: Validate searching records in web table")
	public void validateSearchRecords() {
        homePage.clickOnElementsLnk();
		webTablesPage.clickOnWebTablesOption();
        webTablesPage.searchInTable("Cierra");
        webTablesPage.sleep(3000);
        Assert.assertTrue(webTablesPage.getTableRowsCount() > 0, "Table should display at least one row");
	}


	@Test(description = "TC003: Validate editing a record in web table")
	public void validateEditRecord() {
        homePage.clickOnElementsLnk();
		webTablesPage.clickOnWebTablesOption();
        webTablesPage.editRecord(1, "Jane", "Smith", "jane.smith@example.com", "28", "5500", "QA");
        webTablesPage.searchInTable("Jane");
        webTablesPage.sleep(3000);
        Assert.assertTrue(webTablesPage.getTableRowsCount() > 0, "Table should display at least one row");

    }

	@Test(description = "TC004: Validate deleting a record from web table")
	public void validateDeleteRecord() {
        homePage.clickOnElementsLnk();
		webTablesPage.clickOnWebTablesOption();
        int rowsBeforeDelete = webTablesPage.getTableRowsCount();
		webTablesPage.deleteRecord(1);
		int rowsAfterDelete = webTablesPage.getTableRowsCount();
        System.out.println(rowsAfterDelete);
        Assert.assertTrue(rowsAfterDelete < rowsBeforeDelete, "Row count should decrease after deletion");
	}


	@Test(description = "TC005: Validate table displays rows")
	public void validateTableRows() {
        homePage.clickOnElementsLnk();
		webTablesPage.clickOnWebTablesOption();
		int rowCount = webTablesPage.getTableRowsCount();
		Assert.assertTrue(rowCount > 0, "Table should display at least one row");
		String firstRowContent = webTablesPage.getTableRowContent(2);
		Assert.assertNotNull(firstRowContent, "Row content should not be null");
		Assert.assertTrue(!firstRowContent.isEmpty(), "Row content should not be empty");
	}

}

