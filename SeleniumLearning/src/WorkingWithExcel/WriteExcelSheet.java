package WorkingWithExcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcelSheet {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException  {
		
		
		FileOutputStream fileOutputStream=new  FileOutputStream("./test.xls");
		
		WritableWorkbook workbook=Workbook.createWorkbook(fileOutputStream);
	
		WritableSheet sheet=workbook.createSheet("Madhesh_Sheet", 0);
		
		Label label=new Label(1,1,"learning_Selenium_madhesh");
		Number number=new Number(1, 2, 9741);
		
		sheet.addCell(number);
		sheet.addCell(label);
		
		workbook.write();
		workbook.close();
		
		
	}

}
