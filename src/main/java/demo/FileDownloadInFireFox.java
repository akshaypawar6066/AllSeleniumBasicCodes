package demo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadInFireFox {
	private static String filePath = "C:\\Users\\aksha\\downloads\\";
	private static String fileName = "Sample3.pdf";
	private static String desiredFilePath = "C:\\ChromeDownloads\\";

	public static void main(String[] args) throws InterruptedException {
//		HashMap<String, Object> hm = new HashMap<String, Object>();
//		hm.put("download.default_directory", desiredFilePath);  //Download file at desired location.
		//FirefoxOptions options = new FirefoxOptions();
		//options.setExperimentalOption("prefs", hm);
		//options.addArguments("--disable-notifications");
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.SaveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.folderList", 2);   // 0=desktop, 1=default loation(download), 2=desired location
		profile.setPreference("browser.download.dir", desiredFilePath);   //To download at desired location.
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().deleteAllCookies();
		driver.get("https://filesamples.com/formats/pdf");
		System.out.println("Before download file exists:" + isFileExists(filePath + fileName));
		
		WebElement click=driver.findElement(By.xpath("(//div[@id='output']//a)[1]")); // Download file at default loaction.
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(click));
		click.click();
		
		Thread.sleep(5000);
		System.out.println("After download file exists:" + isFileExists(filePath + fileName));

	}

	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);
		boolean b = file.exists();
		return b;
	}
}
