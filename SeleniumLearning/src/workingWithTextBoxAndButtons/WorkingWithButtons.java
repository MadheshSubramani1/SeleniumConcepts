package workingWithTextBoxAndButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithButtons {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("http://www.leafground.com/pages/Button.html");
	
		//Click the Home button
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		
		
		//Button Position
		WebElement positionButton=driver.findElement(By.id("position"));
		
		Point point=positionButton.getLocation();
		int xValue=point.getX();
		int yValue=point.getY();
		
		System.out.println("X value is : "+ xValue + " Y Value is : "+yValue);
		
		//Button Color
		
		WebElement ButtonColor=driver.findElement(By.id("color"));
		
		String BtnColor=ButtonColor.getCssValue("background-color");
		
		System.out.println("Button Color is : "+ BtnColor);
		
		//Button Size	
		WebElement buttonSize=driver.findElement(By.id("size"));
		 int buttonHeight=buttonSize.getSize().getHeight();
		 int buttonWidth=buttonSize.getSize().getWidth();
		 
		 System.out.println("Button height is : "+buttonHeight +" Button width is : "+buttonWidth);
	}

}
