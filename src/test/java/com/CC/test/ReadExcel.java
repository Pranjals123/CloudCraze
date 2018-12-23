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

	public static final String FILEPATH = "./Testdata.xlsx" ;
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	 public ReadExcel(String sheetname) throws Exception{
		 
		 fis = new FileInputStream(new File(FILEPATH));
		 workbook = new XSSFWorkbook(fis); // XSSFWorkbook for .xlsx file
		 sheet = workbook.getSheet(sheetname); // open sheet 
		 fis.close();
		 
	 }
	 
	
	 
	 public String getCellData(String shtName, String colName, int rowNum)
	  {
		 //ReadExcel(shtName);
		 
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
         }
		return colName;

		 
	  }
      
     

   
	
}
