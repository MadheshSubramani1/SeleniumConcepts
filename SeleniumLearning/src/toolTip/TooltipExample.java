package toolTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipExample {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/tooltip.html");

		WebElement textbox = driver.findElement(By.id("age"));

		String tooltip = textbox.getAttribute("title");

		System.out.println(tooltip);

	}

}
