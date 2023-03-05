package demo;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadInChrome {
	private static String filePath = "C:\\Users\\aksha\\downloads\\";
	private static String fileName = "Sample3.pdf";
	private static String desiredFilePath = "C:\\ChromeDownloads\\";

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("download.default_directory", desiredFilePath);  //Download file at desired location.
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", hm);
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://filesamples.com/formats/pdf");
		System.out.println("Before download file exists:" + isFileExists(filePath+fileName));
		driver.findElement(By.xpath("(//div[@id='output']//a)[1]")).click(); // Download file at default loaction.
		Thread.sleep(5000);
		System.out.println("After download file exists:" + isFileExists(filePath+fileName));

	}

	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
		
	}
}
