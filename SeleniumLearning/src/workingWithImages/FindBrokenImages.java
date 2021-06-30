package workingWithImages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenImages {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Image.html");
		
		List<WebElement> images=driver.findElements(By.tagName("img"));
		
		System.out.println(images.size());
		
		for (WebElement image : images) {
			
			String imageURL=image.getAttribute("src");
			
			URL url=new  URL(imageURL);
			
			HttpURLConnection connection =(HttpURLConnection) url.openConnection();
			
			
			connection.connect();
			
			if(connection.getResponseCode()>=400 || image.getAttribute("naturalWidth").equals("0")) {
				
				System.err.println(imageURL +" >>"+connection.getResponseCode()+">>" +connection.getResponseMessage());				
			}
			else {
				System.out.println(imageURL +" >>"+connection.getResponseCode()+">>" +connection.getResponseMessage());
			}
			
		}
		driver.quit();

	}

}
