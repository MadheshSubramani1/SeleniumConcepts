package handlingAutoComplete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithAutoComplete {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/autoComplete.html");

		WebElement textbox = driver.findElement(By.id("tags"));

		textbox.sendKeys("s");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li")));

		List<WebElement> autoCompleteOptions=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for (WebElement option : autoCompleteOptions) {
			
			if(option.getText().equals("Web Services")) {
				
				option.click();
				break;
			}
		}

		
	}

}
