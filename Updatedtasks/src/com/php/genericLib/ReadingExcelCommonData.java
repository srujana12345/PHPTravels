package com.php.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelCommonData 
{
String path =".\\src\\test\\resources\\testData\\testData.xlsx";
	
	public String getExcelData(String sheetNAme, int rowNum, 
			                        int celNum) throws Throwable{	
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNAme);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		return data;
	}
	public void setExcelData(String sheetNAme, int rowNum, 
            int celNum , String data) throws Throwable{	
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNAme);
		Row row = sh.getRow(rowNum);
        Cell cel = row.createCell(celNum);
        cel.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        wb.close();
}

}
