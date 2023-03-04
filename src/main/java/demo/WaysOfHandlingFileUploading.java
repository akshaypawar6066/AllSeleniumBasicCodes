package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaysOfHandlingFileUploading {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		uploadFileWithSendKeys();
		uploadFileWithRobotClass();
		uploadFileWithAutoItTool();
	}

	public static void uploadFileWithSendKeys() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://monster.com");
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\aksha\\UploadFile\\TextFile.txt");
		Thread.sleep(2000);
		driver.close();
	}

	public static void uploadFileWithRobotClass() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://monster.com");
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		Thread.sleep(2000);
		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", uploadFile);
		StringSelection ss = new StringSelection("C:\\Users\\aksha\\UploadFile\\TextFile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// Use Robot class for paste
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.close();

	}

	public static void uploadFileWithAutoItTool() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://monster.com");
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		Thread.sleep(2000);
		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", uploadFile);
		Runtime.getRuntime().exec("C:\\Users\\aksha\\UploadFile\\UploadScript.exe");
		Thread.sleep(2000);
		driver.close();

	}

}
