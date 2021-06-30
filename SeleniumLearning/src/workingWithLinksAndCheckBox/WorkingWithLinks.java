package workingWithLinksAndCheckBox;

import java.util.AbstractSequentialList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithLinks {

	public static void main(String[] args) {
		
		WebDriver driver=new  ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		driver.navigate().back();
		
		String where=driver.findElement(By.partialLinkText("Find where am")).getAttribute("href");
		
		System.out.println("The link is rediretced to "+where );
		
		driver.findElement(By.partialLinkText("Verify am I")).click();
		
		String title=driver.getTitle();
		
		if(title.contains("404")) {
			System.out.println("link is broken");
		}
		else{
			System.out.println("link is not broken");
		}
		
		driver.navigate().back();
		
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());

	}

}
