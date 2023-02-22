package demo;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators2 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.operadriver().setup();
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String []cred=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(cred[0]);
		driver.findElement(By.name("inputPassword")).sendKeys(cred[1]);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.submit ")).click();
		Thread.sleep(2000);
		String loggedInMsg = driver.findElement(By.tagName("p")).getText();
		System.out.println(loggedInMsg);
		Assert.assertEquals(loggedInMsg, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + cred[0] + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

	public static String[] getPassword(WebDriver driver) throws InterruptedException {
		String userName="Akshay";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		Thread.sleep(1000);
		String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String passArray[] = passwordText.split("'");
		String password=passArray[1];
	     String array[]= {userName,password};
		return array; 
	    
	}
}
