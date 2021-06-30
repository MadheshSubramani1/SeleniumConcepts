package DataDriven;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utility.DataDrivenUtilities;

public class UsingExcelSheet {

	int i = 1;
	static String paths = System.getProperty("user.dir") + "\\loginCredentials.xls";
	Object[][] data = null;
	WebDriver driver;

	private String todayDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		return todayDate;
	}

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public Object[][] getExcelData() throws BiffException, IOException {

		FileInputStream fileInputStream = new FileInputStream(paths);

		Workbook workbook = Workbook.getWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(0);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		System.out.println(rowCount);
		System.out.println(columnCount);
		String testData[][] = new String[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				if (j < 2) {
					testData[i - 1][j] = sheet.getCell(j, i).getContents();
				}
			}
		}

		DataDrivenUtilities.CreateColumnHeader(paths, "Sheet1", "Status" + todayDate());
		return testData;

	}

	@DataProvider(name = "loginDataProvider")
	private Object[][] loginData() throws BiffException, IOException {

		data = getExcelData();

		return data;

	}

	@Test(dataProvider = "loginDataProvider")
	public void Method(String uname, String pwd) throws IOException {

		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement username = driver.findElement(By.id("txtUsername"));

		username.sendKeys(uname);

		WebElement password = driver.findElement(By.id("txtPassword"));

		password.sendKeys(pwd);

		driver.findElement(By.id("btnLogin")).click();

		if (driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).size() != 0) {

			DataDrivenUtilities.setCellData("Sheet1", "Status" + todayDate(), i, "Pass", paths);
			i = i + 1;
		} else {
			DataDrivenUtilities.setCellData("Sheet1", "Status" + todayDate(), i, "Fail", paths);
			i = i + 1;
		}

	}

}
