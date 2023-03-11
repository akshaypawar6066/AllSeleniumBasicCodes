package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4JDemo {
	
	//How to generate logs in selenium
   /*a)How to generate the logs:->Add log4j jars (Using log4j jars)
    * b)How it works:->it reads log4j configuration from log4j.properties file
    * c)where to create properties file:->Create inside resources folder
    */ 
	WebDriver driver;
	Logger logger=LoggerFactory.getLogger("Log4JDemo.class");
	@BeforeMethod
    public void setUp()
    {
       
    	WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(priority = 1, invocationCount = 1)
    public void searchOnGooglePage() throws InterruptedException
    {
    	driver.get("https://www.google.co.in/");
    	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("chatGPT");
    	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
    	logger.info("Added tesxt and hits enter");
    	Thread.sleep(2000);
    	boolean b=driver.getPageSource().contains("Shopping");
    	Assert.assertTrue(b);
    	
    }
    @Test(priority = 2, timeOut = 10000,enabled = false)
    public void navigateToRegisterPage() throws InterruptedException
    {
    	driver.get("https://rahulshettyacademy.com/");
    	Thread.sleep(2000);
    	boolean b=driver.getPageSource().contains("Register");
    	Assert.assertTrue(b);
    }
    
    @AfterMethod
   public void tearDown()
   {
    	driver.close();
   }
}
