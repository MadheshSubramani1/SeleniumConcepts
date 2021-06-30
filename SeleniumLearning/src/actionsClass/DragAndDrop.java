package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public static void dragAndDropMethod() {

		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/drop.html");

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		// actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		actions.dragAndDrop(draggable, droppable).build().perform();
	}

}
