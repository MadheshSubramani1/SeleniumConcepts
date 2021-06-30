package iFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/frame.html");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"wrapframe\"]/iframe")));
		driver.switchTo().frame(0);
		WebElement button1=driver.findElement(By.id("Click"));
		button1.click();
		String text=driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		
		
		WebElement button2=driver.findElement(By.id("Click1"));
		button2.click();
		
		
		driver.switchTo().defaultContent();
		
		int frameSize=driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameSize);
		
		
	
		
		
		
	}

}
