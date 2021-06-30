package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Testing_dropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		String[] expected= {"Select training program using Index", "Selenium","Appium","UFT/QTP","Loadrunner"};
		
		WebElement dropdown=driver.findElement(By.id("dropdown1"));
		
		Select select=new Select(dropdown);
		
		String text=select.getFirstSelectedOption().getText();
		
		Assert.assertEquals(text, "Select training program using Index");
		
		System.out.println("First selected dropdown option is verified successfully");
	
		List<WebElement> list=select.getOptions();
		Assert.assertEquals(list.size(), 5);
		
		System.out.println("Count verified Successfully");
		
		
		for (int i=0;i<list.size();i++) {
			
			String totalText=list.get(i).getText();
			Assert.assertEquals(totalText, expected[i]);
			
		}
		
		System.out.println("Text verified successfully");
		
		
	}

}
