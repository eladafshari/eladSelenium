package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;
	
	public ExcelData () throws Exception {
		File src = new File("‪E:\\EladWorkspace\\NbaAutomation\\Excel\\NbaData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
	}
	
	public XSSFSheet getSheetByIndex (int sheetIndex) {
		return workbook.getSheetAt(sheetIndex);
	}
	
	public XSSFSheet getSheetByName (String sheetName) {
		return workbook.getSheet(sheetName);
	}
	
	public void initializeSheetByIndex (int sheetIndex) {
		sheet = getSheetByIndex(sheetIndex);
	}
	
	public void initializeSheetByName (String sheetName) {
		sheet = getSheetByName(sheetName);
	}
	
	public int getNumberOfRows () {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getNumberOfCellsInRow (int rowIndex) {
		return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
	}
	
	public String getCellData (int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	}
	
	public String[] getDataOfAllRow (int rowIndex) {
		int NumOfRows = getNumberOfCellsInRow(rowIndex);
		String[] arrData = new String[NumOfRows];
		
		for (int i = 0; i < NumOfRows; i++) {
			arrData[i] = getCellData(rowIndex, i);
		}
		return arrData;
	}
	
	public Object[][] getAllExcelData () {
		int NumOfRows = getNumberOfRows();
		int NumOfCells = getNumberOfCellsInRow(0);
		Object[][] data = new Object[NumOfRows][NumOfCells];
		
		for (int i = 0; i < NumOfRows; i++) {
			for (int j = 0; j < NumOfCells; j++) {
				data[i][j] = getCellData(i, j);
			}
		}
		return data;
	}
	
	public Object[][] getExcelDataBetweenRows (int startRowIndex , int endRowIndex) {
		int NumOfRows = (endRowIndex - startRowIndex) + 1;
		int NumOfCells = getNumberOfCellsInRow(0);
		Object[][] data = new Object[NumOfRows][NumOfCells];
		
		for (int i = 0; i < NumOfRows; i++) {
			for (int j = 0; j < NumOfCells; j++) {
				data[i][j] = getCellData(i, j);
			}
		}
		return data;
	}
	
	
}
