package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingRadioButtons {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");

		driver.findElement(By.id("no")).click();

		WebElement uncheckedButtton = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[2]/input"));

		WebElement checkedButtton = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[3]/input"));

		boolean uncheckedButttonstatus = uncheckedButtton.isSelected();
		boolean checkedButttonstatus = checkedButtton.isSelected();

		if (checkedButttonstatus) {
			System.out.println("Application defaultly selected the checked button");
		}
		if (uncheckedButttonstatus) {
			System.out.println("Application defaultly selected the unchecked button");
		}

	}

}
