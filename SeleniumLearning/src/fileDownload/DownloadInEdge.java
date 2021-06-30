package fileDownload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class DownloadInEdge {

	// if our selenium version is below 4, we neeed to download the edge
	// selenium-tools-java..

	public static void main(String[] args) {

		File paths = new File(System.getProperty("user.dir") + File.separator + "DownloadFile");

		EdgeOptions options = new EdgeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		// to stop the pdf preview
		prefs.put("plugins.always_open_pdf_externally", true);

		//download to desired location
		prefs.put("download.default_directory", paths.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new EdgeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");

		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a[1]")).click();

	}

}
