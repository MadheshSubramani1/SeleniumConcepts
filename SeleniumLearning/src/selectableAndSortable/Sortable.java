package selectableAndSortable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/sortable.html");
		
		List<WebElement> allOptions=driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		System.out.println(allOptions.size());
		
		WebElement dragElement=allOptions.get(6);
		WebElement dropElement=allOptions.get(0);
		
		Actions actions=new Actions(driver);
		
		actions.dragAndDrop(dragElement, dropElement).build().perform();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
