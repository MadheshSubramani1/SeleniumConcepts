package WorkingWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelSheet {

	public static void main(String[] args) throws BiffException, IOException {
		
		FileInputStream  fileInputStream=new FileInputStream("./test.xls");
		
		Workbook workbook=Workbook.getWorkbook(fileInputStream);
		
		Sheet sheet=workbook.getSheet(0);
		
		//String value=sheet.getCell(1,1).getContents();
		
		
		int rowCount=sheet.getRows();
		int columnCount=sheet.getColumns();
		
		for(int i=1;i<rowCount;i++) {
			
			for(int j=0; j<columnCount;j++) {
				
				String value=sheet.getCell(j,i).getContents();
				System.out.println(value);
			}
		}
		
		
		

	}

}
