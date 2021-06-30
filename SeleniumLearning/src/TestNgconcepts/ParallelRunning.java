package TestNgconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelRunning {

	WebDriver driver = null;

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

	}

	@Test
	public void openTheHomePage() {

		driver.get("http://www.leafground.com/");
		
		System.out.println(driver.toString());
		
	   System.out.println("current thread is: "+Thread.currentThread().getId());

		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
