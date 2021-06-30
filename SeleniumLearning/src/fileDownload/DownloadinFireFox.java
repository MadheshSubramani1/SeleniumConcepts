package fileDownload;

import java.io.File;
import java.util.UUID;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadinFireFox {
	
	public static void main(String[] args) {
		
		File folder=new File(UUID.randomUUID().toString());
		FirefoxOptions options = new FirefoxOptions();
		
		FirefoxProfile profile = new FirefoxProfile();

		//to stop  the save location confirmation window
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		
		//to disable the pdf preview
		profile.setPreference("pdfjs.disabled", true);
		
		// to download the file in desired location
		profile.setPreference("browser.download.dir", folder.getAbsolutePath());
		profile.setPreference("browser. download. folderList", 2);
		
		options.setProfile(profile);

		WebDriver driver = new FirefoxDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download PDF")).click();
	}

}
