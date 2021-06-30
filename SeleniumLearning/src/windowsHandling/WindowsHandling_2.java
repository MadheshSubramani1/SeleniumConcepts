package windowsHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		WebElement secondButton = driver.findElement(By.
		xpath("//*[@id='contentblock']/section/div[2]/div/div/button"));

		secondButton.click();

		Set<String> allWindow = driver.getWindowHandles();

		List<String> listOfWindows = new ArrayList<String>(allWindow);

		driver.switchTo().window(listOfWindows.get(1));

		System.out.println(driver.getTitle());

		WebElement brokenLink = driver.findElement(By.
		xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/a"));
		brokenLink.click();

	}
}