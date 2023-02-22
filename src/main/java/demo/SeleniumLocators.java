package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLocators {
	public static void main(String[] args) throws InterruptedException {
		String password = "";
		String farrayPass = "";
		SoftAssert softAssert = new SoftAssert();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Akshay");
		driver.findElement(By.name("inputPassword")).sendKeys("Hello");
		driver.findElement(By.className("signInBtn")).click();
		String getText = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println("Error messag is:" + getText);
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Akshay");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Akshay@q123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("John@321");
		driver.findElement(By.xpath("(//div/form/input)[3]")).sendKeys("65645456");
		String fpt = driver.findElement(By.xpath("//h2[text()='Forgot password']")).getText();
		System.out.println("Forgot password text is:" + fpt);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String resetPasswordMsg = driver.findElement(By.className("infoMsg")).getText();
		System.out.println("After reset message is:" + resetPasswordMsg);
		
		/////// Login to application//////
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button.submit ")).click();
		String homePageText=driver.findElement(By.xpath("//div/h2")).getText();
		System.out.println("On home page text is:"+homePageText);
		Assert.assertEquals(driver.getPageSource().contains("Hello Akshay,"), true);
		driver.close();
		
		

	}
}
