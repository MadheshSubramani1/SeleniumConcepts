package windowsHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling_3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();

		Set<String> allwindows = driver.getWindowHandles();

		Iterator<String> itr = allwindows.iterator();

		String parentWindow = itr.next();
		String childWindow = itr.next();

		driver.switchTo().window(childWindow);

		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[3]/a")).click();
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();

	}
}