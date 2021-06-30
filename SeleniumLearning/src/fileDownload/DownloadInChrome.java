package fileDownload;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DownloadInChrome {

	public static void main(String[] args) {

		File path = new File(System.getProperty("user.dir") + File.separator + "DownloadFile");

		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		// disabele the popups
		prefs.put("profile.managed_default_content_settings.popups", 0);

		// download the desired location
		prefs.put("download.default_directory", path.getAbsolutePath());

		// to stop the pdf preview
		prefs.put("plugins.always_open_pdf_externally", true);

		// to start with maximize window
		options.addArguments("--start-maximized");

		// to disable the notification
		options.addArguments("--disable-notifications");

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download PDF")).click();

	}

}
