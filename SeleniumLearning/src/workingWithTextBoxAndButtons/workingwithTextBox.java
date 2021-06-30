package workingWithTextBoxAndButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workingwithTextBox {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		WebElement firstTextBox=driver.findElement(By.id("email"));
		firstTextBox.sendKeys("test@gmail.com");
		
		WebElement secondTextBox=driver.findElement(By.
		xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
		secondTextBox.sendKeys("Test Object");
		
		WebElement ThirdTextBox=driver.findElement(By.name("username"));
		String defaultText=ThirdTextBox.getAttribute("value");
		System.out.println(defaultText);
		
		
		WebElement fourthTextBox =driver.findElement(By.
		xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input"));
		fourthTextBox.clear();
		
		WebElement fifthTextBox=driver.findElement(By.
		xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
		
		if(fifthTextBox.isEnabled()) {
			System.out.println("Textbox is enabled");
		}else {
			System.out.println("Text box is disabled");
		}
		
		

	}

}
