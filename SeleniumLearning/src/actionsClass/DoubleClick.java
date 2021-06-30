package actionsClass;

import org.apache.commons.exec.launcher.Java13CommandLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {

	@Test
	public static void doubleClick() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://api.jquery.com/dblclick/");

		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("window.scrollTo(0, 3000)");
		 */

		Actions actions = new Actions(driver);

		driver.switchTo().frame(0);

		WebElement doubleClick = driver.findElement(By.xpath("/html/body/div"));

		actions.doubleClick(doubleClick).build().perform();

	}

}
