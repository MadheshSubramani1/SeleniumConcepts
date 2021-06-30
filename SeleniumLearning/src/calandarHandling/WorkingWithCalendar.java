package calandarHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithCalendar {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Calendar.html");
		
		WebElement textBox=driver.findElement(By.id("datepicker"));
		
		//textBox.sendKeys("07/25/2021",Keys.ENTER);
		
		textBox.click();
		
		WebElement nextButton=driver.findElement(By.
		xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
		
		nextButton.click();
		
		WebElement date_30=driver.findElement(By.
		xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a"));
		
		date_30.click();
		
		
		
		
		
	}

}
