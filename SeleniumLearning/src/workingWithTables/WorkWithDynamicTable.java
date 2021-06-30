package workingWithTables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithDynamicTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		
		List<WebElement> columnCount=driver.findElements(By.tagName("th"));
		
		System.out.println("Column Count isx-"+ columnCount.size());
		
		List<WebElement> rowCount=driver.findElements(By.tagName("tr"));
		
		System.out.println("Row Count is-"+rowCount.size());
		
		WebElement progressvalue=driver.findElement(By.
				xpath("//td[normalize-space()='Learn to interact with Elements']/following::td[1]"));
		
		System.out.println("Learn to interact With progress value -"+progressvalue.getText() );
		
		List<WebElement> allProgress=driver.findElements(By.xpath("//td[2]"));
		
		List<Integer> allProgressValue= new ArrayList<Integer>();
		
		for (WebElement webElement : allProgress) {
			
			String individualProgress=webElement.getText().replace("%","");
			
			allProgressValue.add(Integer.parseInt(individualProgress));
		}
		
		Integer smallValue=Collections.min(allProgressValue);

		/*
		 * String smallStringvalue=smallValue.toString()+"%";
		 * System.out.println(smallStringvalue);
		 */
		
	    String xpath="//td[text()='"+smallValue+"%"+"']//following::td[1]//input";
	    
	    driver.findElement(By.xpath(xpath)).click();

	}

}
