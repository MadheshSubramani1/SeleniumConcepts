package workingWithLinksAndCheckBox;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.joshworks.restclient.http.HttpResponse;
import io.joshworks.restclient.http.Json;
import io.joshworks.restclient.http.Unirest;

public class FindBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");

		List<WebElement> list = driver.findElements(By.tagName("a"));

		list.size();

		for (int i = 0; i < list.size(); i++) {

			String Url = list.get(i).getAttribute("href");
			
			
			URL link=new URL(Url);
			
			HttpURLConnection httpurl=(HttpURLConnection) link.openConnection();
			
			httpurl.connect();
			
			if(httpurl.getResponseCode()>=400) {
			
				System.out.println(Url +" is broken link");
			}else {
				System.out.println(Url +" is valid link");
			}
			

			/*
			 * HttpResponse<Json> jsonResponse = Unirest.get(Url).asJson();
			 * if ((jsonResponse.getStatus()) >= 400) { 
			 * System.out.println(Url + " is broken link"); 
			 * }else{
			 *  System.out.println(Url + " is Valid link");
			 * }
			 */

		}

	}

}
