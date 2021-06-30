package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextClickUsingActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		/*
		 * driver.get("https://play.letcode.in/contextmenu");
		 * 
		 * Actions actions = new Actions(driver);
		 * 
		 * WebElement RightClickButton =
		 * driver.findElement(By.xpath("//*[text()=' Right Click ']"));
		 * 
		 * actions.contextClick(RightClickButton).build().perform();
		 * 
		 * WebElement ClickMeButton =
		 * driver.findElement(By.xpath("//*[text()='Click me']"));
		 * ClickMeButton.click();
		 * 
		 * System.out.println(driver.switchTo().alert().getText());
		 * 
		 * driver.switchTo().alert().accept();
		 */

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions actions = new Actions(driver);
		
		WebElement RigtClickMeButton= driver.findElement(By.
				xpath("//span[text()='right click me']"));
        actions.contextClick(RigtClickMeButton).build().perform();
        
        WebElement EditButton=driver.findElement(By.xpath("//span[text()='Edit']"));
        
        EditButton.click();
        
        System.out.println(driver.switchTo().alert().getText());
        
        driver.switchTo().alert().accept();
        
        
	}

}
