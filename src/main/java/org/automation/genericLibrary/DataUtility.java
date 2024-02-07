package org.automation.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FrameWorkConstants.properties_path);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(FrameWorkConstants.excel_path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(cellNum).toString();
	}
	
	public static Object[][] getMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);

		int lastRowNum = sh.getPhysicalNumberOfRows();
		int lastCellNumber = sh.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr = new Object[lastRowNum-1][lastCellNumber];
		
		for(int i=0; i<lastRowNum; i++) {
			for(int j=0;j<lastCellNumber;j++) {
				arr[i-1][j]=sh.getRow(i).getCell(j).toString();
		}
	  }
		return arr;
	}
}
