package popupHandling;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('hello Embitel')");

		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		driver.quit();

	}

}
