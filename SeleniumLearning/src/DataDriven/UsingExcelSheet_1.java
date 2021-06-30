package DataDriven;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.DataProviderHolder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utility.DataDrivenUtilities;

public class UsingExcelSheet_1 {

	WebDriver driver;
	String[][] data = null;

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public String[][] getExcelData() throws BiffException, IOException {

		FileInputStream fileInputStream = new FileInputStream("./loginCredentials.xls");
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(0);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String[][] testData = new String[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}

		return testData;
	}

	@DataProvider(name="loginDataProvider")
	public String[][] logindata() throws BiffException, IOException {

		data = getExcelData();
		return data;
	}

	@Test(dataProvider = "loginDataProvider")
	public void Method(String uname, String pwd) throws IOException {

		
			try {
				driver.get("https://opensource-demo.orangehrmlive.com/");

				WebElement username = driver.findElement(By.id("txtUsername"));

				username.sendKeys(uname);

				WebElement password = driver.findElement(By.id("txtPassword"));

				password.sendKeys(pwd);

				driver.findElement(By.id("btnLogin")).click();
				
				String dashboard=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
				
				//assert driver.getPageSource().contains(errormessage);
			} catch (Exception e) {
				
				System.out.println("Login test is failed");
				
				
			}
		
		
			
	}
}
