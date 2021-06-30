package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	Object[][] data = { { "Admin", "", "Password cannot be empty" }, { "", "dummy", "Username cannot be empty" },
			{ "dummy", "dummy", "Invalid credentials" }, { "Admin", "dummy", "Invalid credentials" },
			{ "dummy", "admin123", "Invalid credentials" } };

	@DataProvider(name = "loginDataProvider")
	private Object[][] loginData() {

		return data;

	}

	@Test(dataProvider = "loginDataProvider")
	public void ErrorMessageValidation(String uname, String pwd, String errorMessage) {

		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement username = driver.findElement(By.id("txtUsername"));

		username.sendKeys(uname);

		WebElement password = driver.findElement(By.id("txtPassword"));

		password.sendKeys(pwd);

		driver.findElement(By.id("btnLogin")).click();

		try {
			Assert.assertTrue(driver.getPageSource().contains(errorMessage));
		} catch (AssertionError e) {
			System.err.println("Login page Error Message Validation is Failed");
		}

	}

}
