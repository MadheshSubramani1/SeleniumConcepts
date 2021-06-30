package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement dropdown=driver.findElement(By.id("dropdown1"));
		
		Select select=new Select(dropdown);
		
		select.selectByIndex(1);
		
		Thread.sleep(2000);
		
		select.selectByValue("2");
		
		Thread.sleep(2000);
		
		select.selectByVisibleText("Loadrunner");
    ///////////////////////////////////////////////////////////////////
		
		System.out.println(select.getOptions().size());	
		
	//////////////////////////////////////////////////////////////////	
		
		WebElement sentKeysDropdown=driver.findElement(By.xpath
				("//*[@id=\"contentblock\"]/section/div[5]/select"));
		
		sentKeysDropdown.sendKeys("Loadrunner");
    ////////////////////////////////////////////////////////////////////
		
		WebElement selectMultiple=driver.findElement(By.xpath
				("//*[@id=\"contentblock\"]/section/div[6]/select"));
		
		Select select1=new Select(selectMultiple);
		
		select1.selectByIndex(1);
		select1.selectByIndex(2);
		select1.selectByIndex(3);
		
		
	}

}
