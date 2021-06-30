package windowsHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling_1 {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		WebElement secondButton= driver.findElement(By.
		xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		
		secondButton.click();
		
		Set<String> allWindow=driver.getWindowHandles();
		
		for(String newWindow:allWindow ) {
			
			driver.switchTo().window(newWindow);
			String title =driver.getTitle();
			
			if (title.equals("TestLeaf - Interact with HyperLinks")) {
				
				WebElement brokenLink=driver.findElement(By.
				xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/a"));
				brokenLink.click();
				
			}
		}
	}

}
