package com.CC.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static final String FILEPATH = "F:\\selenium\\CloudCraze\\src\\main\\resources\\Testdata.xlsx" ;
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	 public ReadExcel(String sheetname) throws Exception{
		 
		 try {
			fis = new FileInputStream(new File(FILEPATH));
			 workbook = new XSSFWorkbook(fis); // XSSFWorkbook for .xlsx file
			 sheet = workbook.getSheet(sheetname); // open sheet 
			 fis.close();
			 
		 } 
		 catch (Exception e) {
			
			 System.out.print(e.getMessage());
		}
		 
	 }
	 
	
	
	 public String ReadExcel(String shtName, String colName, int rowNum)
	  {
		 /*//ReadExcel(shtName);
		 
		 Iterator<Row> rowIterator = sheet.iterator();

         // Traversing over each row of XLSX file
          while (rowIterator.hasNext())
          {
              Row row = rowIterator.next();

                 if(row.getRowNum()!=0) // skip title row
                 {
                     Iterator  cellIterator = row.cellIterator();

                     while (cellIterator.hasNext())
                      {

                         Cell cell = (Cell) cellIterator.next();

                         System.out.print(cell.getStringCellValue() + "\t");
                      }

                  }
         }*/
		 
		 
		 
		try {
			
			int colNum = -1;
			sheet = workbook.getSheet(shtName);
			row = sheet.getRow(0);
			
			for(int i=0; i<row.getLastCellNum(); i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					colNum = i;
				}
			}
			
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			return cell.getStringCellValue();
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			return "data not found";
		}

		 
	  }
     
     

   
	
}
