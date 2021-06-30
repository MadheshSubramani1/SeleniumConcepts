package workingWithLinksAndCheckBox;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithCheckBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/checkbox.html");

		WebElement java = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]/input"));
		java.click();

		WebElement selenium = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input"));

		if (selenium.isSelected()) {

			System.out.println("Selenium is selected");
		}

		WebElement CheckBox1 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[1]/input"));
		WebElement CheckBox2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input"));

		if (CheckBox1.isSelected()) {
			CheckBox1.click();
		}
		if (CheckBox2.isSelected()) {
			CheckBox2.click();
		}

		List<WebElement> allOptions = driver
				.findElements(By.xpath("//*[@id='contentblock']/section/div[4]/div/input"));
		System.out.println(allOptions.size());
		for (WebElement webElement : allOptions) {
			webElement.click();
		}

	}

}