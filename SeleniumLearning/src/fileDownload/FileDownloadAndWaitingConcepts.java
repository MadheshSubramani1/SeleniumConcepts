package fileDownload;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadAndWaitingConcepts {

	static File folderPath;

	public static void main(String[] args) throws InterruptedException {

		folderPath = new File(System.getProperty("user.dir") + File.separator + "DownloadedFile");
		folderPath.mkdir();

		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", folderPath.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download Excel")).click();

		waitForDownload(folderPath.getAbsolutePath(), "testleaf.xlsx");

		if (folderPath.listFiles().length == 0) {
			System.out.println("File is not downloaded");
		}

	    driver.quit();

		for (File file : folderPath.listFiles()) {
			file.delete();
		}
		folderPath.delete();
	}

	public static void waitForDownload(String path, String filename) throws InterruptedException {

		int num = 1;

		while (num <= 10) {

			Thread.sleep(500);

			File folder = new File(path);

			File[] totalFilese = folder.listFiles();

			for (File file : totalFilese) {

				if (file.getName().equals(filename)) {
					num = 10;
					System.out.println("File is downloaded");
					break;
				}
			}

			num = num + 1;

		}
	}
}
