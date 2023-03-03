package demo;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uplo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://monster.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();

		// Using sendKeys() method.
		// driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\aksha\\OneDrive\\Documents\\Resume\\Resume.pdf");

		// Using Robot class
		WebElement btn = driver.findElement(By.id("file-upload"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn); // This will perform the click action on btn

		/*
		 * Copy the file path paste the file path in file name //This are Keyboar
		 * actions. press enter button
		 */

		// Put the file into the clipboard (ctrl+c)
		StringSelection ss = new StringSelection("C:\\Users\\aksha\\OneDrive\\Documents\\Resume\\Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Press (ctrl+v)
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		// Press Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
