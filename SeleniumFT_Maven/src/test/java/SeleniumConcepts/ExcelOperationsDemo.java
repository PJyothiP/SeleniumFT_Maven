package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationsDemo {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream f;
	static String path = ".\\TestData\\DummyData.xlsx";
	static XSSFRow row;
	static XSSFCell cell;
	static FileOutputStream fo;
	public static void main(String[] args) throws IOException {
		try{
			f = new FileInputStream(path);
			workbook = new XSSFWorkbook(f);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		sheet = workbook.getSheetAt(0);
		writeData();
		writeColumnData();
		readData();
	}
	private static void readData() {
		Iterator<Row> xr  = sheet.iterator();
		while(xr.hasNext()) {
			row = (XSSFRow) xr.next();
			Iterator<Cell> xc = row.cellIterator();	
			while(xc.hasNext()) {
				cell = (XSSFCell) xc.next();
				switch(cell.getCellType()) {
				case STRING : 
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC :
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN : 
					System.out.print(cell.getBooleanCellValue());
					break;
					default : 
						System.out.print("Invalid Cell Type");
				}System.out.print(" -- ");
				
			}System.out.println();
		}
	}
	private static void writeData() throws IOException {
		int rowCount = sheet.getLastRowNum();
		System.out.println("This is the row Count of the sheet : "+rowCount);
		sheet.createRow(++rowCount);
		row = sheet.getRow(rowCount);
		row.createCell(0).setCellValue("Charitha");
		row.createCell(1).setCellValue(30);
		fo = new FileOutputStream(path);
		workbook.write(fo);
	}	
	private static void writeColumnData() throws IOException {
		int rowCount = sheet.getLastRowNum();
		for(int i = 1;i<=rowCount;i++) {
			int ColumnCount = sheet.getRow(i).getLastCellNum();
			sheet.getRow(i).createCell(++ColumnCount).setCellValue("Passed");
		}
		fo = new FileOutputStream(path);
		workbook.write(fo);
	}
}
