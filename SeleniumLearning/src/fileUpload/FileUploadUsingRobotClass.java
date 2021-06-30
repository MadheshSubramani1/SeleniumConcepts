package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploadUsingRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");

		WebElement uploadButton = driver.findElement(By.name("userfile"));
		
		uploadButton.click();
		
		Thread.sleep(3000);
		
		StringSelection selection=new StringSelection("C:\\Users\\emb-madhsub\\Downloads\\testleaf.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
