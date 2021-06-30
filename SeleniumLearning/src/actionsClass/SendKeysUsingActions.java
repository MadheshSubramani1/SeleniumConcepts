package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysUsingActions {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions actions=new  Actions(driver);
		
		WebElement searchbar=driver.findElement(By.id("twotabsearchtextbox"));
		
		actions.sendKeys(searchbar, "mobiles").build().perform();
		
		Thread.sleep(3000);
		
		actions.sendKeys(searchbar, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();

		Thread.sleep(3000);
		driver.close();
	}

}
