package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenerateEvidence {
	public static void addStepAndScreenshot (WebDriver driver, String fileName, String stepDescription ) throws IOException, InvalidFormatException, InterruptedException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageName = "capture_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
        String dirEvidence = System.getProperty("user.dir")+"Evidence";
        String imagePath = dirEvidence + imageName;
        FileUtils.copyFile(screen, new File(imagePath));
		
	    
	    File fichero = new File(fileName);
	    XWPFDocument docx;
	    
	    if(!fichero.exists()) {
	    	docx = new XWPFDocument();
	    }else {
	    	FileInputStream ficheroStream = new FileInputStream(fichero);
	    	docx = new XWPFDocument(ficheroStream);
	    }
	    
	    XWPFParagraph paragraph = docx.createParagraph();
	    XWPFRun run = paragraph.createRun();
	    run.setText(stepDescription);
	    run.setFontSize(10);	    
	    FileInputStream pic = new FileInputStream(imagePath);
	    run.addPicture(pic, Document.PICTURE_TYPE_PNG, imagePath,
	    Units.toEMU(500), Units.toEMU(200));
	    pic.close();

	    FileOutputStream out = new FileOutputStream(fileName);
	    docx.write(out);
	    out.flush();
	    out.close();
	    docx.close();
	    
	    TimeUnit.SECONDS.sleep(1);
	}
	
	public static void addMainTitle(String fileName, String title, int fontSize) throws IOException, InterruptedException {
		File fichero = new File(fileName);
		XWPFDocument docx;
		
	    if(!fichero.exists()) {
	    	docx = new XWPFDocument();
	    }else {
	    	FileInputStream ficheroStream = new FileInputStream(fichero);
	    	docx = new XWPFDocument(ficheroStream);
	    }
	    
	    XWPFParagraph paragraph = docx.createParagraph();
	    XWPFRun run = paragraph.createRun();
	    run.setText(title);
	    run.setFontSize(fontSize);
	    
	    FileOutputStream out = new FileOutputStream(fileName);
	    docx.write(out);
	    out.flush();
	    out.close();
	    docx.close();
	    
	    TimeUnit.SECONDS.sleep(1);

	}

}
