package workingWithImages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithImages {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/Image.html");

		WebElement HomepageImage = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));

		HomepageImage.click();
		driver.navigate().back();

		WebElement BrokenImage = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));

		if (BrokenImage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("This is broken image");
		} else {
			System.out.println("This is not broken image");
		}

	}

}
