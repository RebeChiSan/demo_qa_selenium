package Tests.Elements;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.ElementsPage;
import Pages.HomePage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadDownload extends BaseTest {
	HomePage homePage;
	ElementsPage uploadDownloadPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        uploadDownloadPage = new ElementsPage(driver);
    }

    @Test(description = "TC001: Validate file download")
	public void validateFileDownload() {
        homePage.clickOnElementsLnk();
		uploadDownloadPage.clickOnUploadDownloadOption();
		uploadDownloadPage.clickOnDownloadButton();
		uploadDownloadPage.sleep(3000);
		String downloadPath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "sampleFile.jpeg";
		File downloadedFile = new File(downloadPath);
        String name = downloadedFile.getName();
        System.out.println(downloadPath);
		Assert.assertTrue(downloadedFile.exists(), "Downloaded file should exist");
	}

	@Test(description = "TC002: Validate file upload")
	public void validateFileUpload() {
        homePage.clickOnElementsLnk();
        uploadDownloadPage.clickOnUploadDownloadOption();
        uploadDownloadPage.uploadFile("C:\\Users\\rebec\\DemoQA\\Data\\chemmsmex.png");
		Assert.assertTrue(uploadDownloadPage.isUploadedFilePathDisplayed(), "Upload confirmation message should be displayed");
        Assert.assertTrue(uploadDownloadPage.getUploadedFilePath().contains("chemmsmex"), "Uploaded path should contain the test file name");

    }

}

