package actionsClass;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/mouseOver.html#");

		WebElement HoverButton = driver.findElement(By.linkText("TestLeaf Courses"));

		Actions actions = new Actions(driver);

		actions.moveToElement(HoverButton).build().perform();

		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"wrapper\"]/div/div[5]/ul/li/ul/li"));

		for (WebElement allLinks : list) {

			String linkText = allLinks.getText();
			System.out.println(linkText);

		}

		driver.findElement(By.linkText("RPA")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.quit();

	}

}
