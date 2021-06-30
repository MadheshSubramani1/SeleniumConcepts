package windowsHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		String OldWindow = driver.getWindowHandle();

		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();
		Set<String> allwindow = driver.getWindowHandles();
		for (String newWindow : allwindow) {
			driver.switchTo().window(newWindow);
		}
		WebElement editButton = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a"));
		editButton.click();
		driver.close();
		driver.switchTo().window(OldWindow);

		WebElement secondButton = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		secondButton.click();
		int numberOfWindows = driver.getWindowHandles().size();
		System.out.println(numberOfWindows);

		WebElement thirddButton = driver.findElement(By.id("color"));
		thirddButton.click();

		Set<String> allWindwes = driver.getWindowHandles();

		for (String newindow : allWindwes) {

			if (!newindow.equals(OldWindow)) {

				driver.switchTo().window(newindow);
				driver.close();

			}
		}
		
		driver.switchTo().window(OldWindow);
		
		WebElement fourthButton =driver.findElement(By.xpath("(//*[@id='color'])[2]"));
		fourthButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		Set<String> allWindwe = driver.getWindowHandles();

		for (String newindow : allWindwe) {

			if (!newindow.equals(OldWindow)) {

				driver.switchTo().window(newindow);
				driver.close();

			}
		}
		
		

	}
}
