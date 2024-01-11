package com.demo.crm_Hybridframework.base;


	
	import org.apache.poi.ss.usermodel.*;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
import java.util.ArrayList;

	public class ExcelReader {

	    public static ArrayList getTestData(String filePath) {
	    	ArrayList arr = new ArrayList();
	        try {
	            // Specify the path to the Excel file
	            //String filePath1 = "E:\\Excelfile.xlsx";

	            // Create a FileInputStream to read the Excel file
	            FileInputStream fileInputStream = new FileInputStream(new File(filePath));

	            // Create a Workbook instance
	            Workbook workbook = WorkbookFactory.create(fileInputStream);

	            // Get the first sheet from the workbook
	            Sheet sheet = workbook.getSheetAt(0);

	            // Iterate through each row in the sheet
	            for (Row row : sheet) {
	                // Iterate through each cell in the row
	                for (Cell cell : row) {
	                    // Print the value of the cell
	                	arr.add(cell.toString() );
	                }
	                System.out.println(); // Move to the next line after each row
	            }

	            // Close the FileInputStream and workbook to release resources
	            fileInputStream.close();
	            workbook.close();

	        } catch (IOException | org.apache.poi.EncryptedDocumentException e) {
	            e.printStackTrace();
	        }
	        return arr;
	    }
	}



