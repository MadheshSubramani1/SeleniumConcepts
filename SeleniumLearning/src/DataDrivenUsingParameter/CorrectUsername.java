package DataDrivenUsingParameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectUsername {
	
	

	@Test
	@Parameters({"username","password"})
	public void Method(String uname, String pwd) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		
		username.sendKeys(uname);
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		
		password.sendKeys(pwd);
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.quit();

	}

}
