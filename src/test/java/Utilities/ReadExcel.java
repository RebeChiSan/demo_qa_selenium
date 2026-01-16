package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static  Object[][] getCellValue(String filePath,String sheetName) throws Exception {
		FileInputStream file = new FileInputStream(new File(filePath));
		
		XSSFWorkbook libroExcel= new XSSFWorkbook(file);
		
		XSSFSheet Hoja= libroExcel.getSheet(sheetName);
		
		System.out.println(sheetName);
		
		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows();
		int columnas= Hoja.getRow(0).getPhysicalNumberOfCells();
		
		Object cellValue[][]=new Object[filas][columnas];
		
		DataFormatter dataFormatter = new DataFormatter();
		
		for (int r = 0; r < filas; r++) {
		 fila = Hoja.getRow(r);
		 if (fila == null){ 
			 break; 
	     }else{ 
	    	 for (int c = 0; c < columnas; c++) {
	    		 
	    		 cellValue[r][c] = dataFormatter.formatCellValue(Hoja.getRow(r).getCell(c));
	    	 } 
	     }
		 }
		libroExcel.close();
		
		return cellValue; 
	} 
}
