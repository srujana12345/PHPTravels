package com.php.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class FileLib {
	//String excelpath=".\\testdata\\atomate_testcase.xlsx";
	public static String getExcelData(String sheetName,int rowNum,int cellNum ) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
	FileInputStream fis = new FileInputStream(".\\\\testdata\\\\atomate_testcase.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet=wb.getSheet(sheetName);
	Row row=sheet.getRow(rowNum);
	String data=row.getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
	}
//	public void setExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
//	{
//		FileInputStream fObj= new FileInputStream(excelpath);
//		Workbook wb =WorkbookFactory.create(fObj);
//		Sheet sheet=wb.getSheet(sheetName);
//		Row row =sheet.getRow(rowNum);
//		/Cell cell=row.createCell(cellNum); 
////		cell.setCellValue(data);
//		FileOutputStream fos = new FileOutputStream(excelpath);
//		wb.write(fos);
//		wb.close();
//	}
	
	
	public static Properties getPropertiesObj() throws Throwable
	{
		FileInputStream file = new FileInputStream("./testdata/commondata.properties");
		Properties properties= new Properties();
		properties.load(file);
		
		return properties;
		
	}
	
	
		
			
		
	}

