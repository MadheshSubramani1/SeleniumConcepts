package WorkingWithExcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteExcelUsingApachePOI {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fileOutputStream=new FileOutputStream("./madhesh.xls");
	
		Workbook workbook=new HSSFWorkbook();
		
		Sheet sheet=workbook.createSheet("test");
		
		sheet.createRow(3).createCell(5).setCellValue("Sample");
		
		workbook.write(fileOutputStream);
		workbook.close();
		
		
		
	}

}
