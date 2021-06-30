package fileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadConcepts {

	public static void main(String[] args) {

		try {
			WebDriver driver = new ChromeDriver();

			driver.get("http://www.leafground.com/pages/upload.html");

			WebElement uploadButton = driver.findElement(By.name("filename"));
			uploadButton.sendKeys("C:\\Users\\emb-madhsub\\Downloads\\file-sample_1MB.docx");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeContains(uploadButton, "value", "file-sample_1MB.docx"));

			if (uploadButton.getAttribute("value").contains("file-sample_1MB.docx")) {
				System.out.println("file is uploaded");

			}
		} catch (TimeoutException e) {
			System.out.println("File is not uploaded");
		}

	}
}
