package WorkingWithExcel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelUsingApachePOI {

	static List<String> usernameList=new ArrayList<String>();
	static List<String> passwordList=new ArrayList<String>();

	public static void main(String[] args) throws Exception {

		FileInputStream fileInputStream = new FileInputStream("./test.xls");

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

		// String value=hssfSheet.getRow(1).getCell(1).getStringCellValue();

		Iterator<Row> rowIterator = hssfSheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Iterator<Cell> columnIterator = row.iterator();

			int i=2;
			while (columnIterator.hasNext()) {
				
				if(i%2==0) {
					
					usernameList.add(columnIterator.next().getStringCellValue());
				}else {
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i=i+1;
			}
			

		}
		
		System.out.println("Username "+usernameList);
		System.out.println("Password "+passwordList);

	}
}