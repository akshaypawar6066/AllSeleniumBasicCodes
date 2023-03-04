package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoItUploadDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		test();
	}
   public static void test() throws IOException, InterruptedException
   {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver=new ChromeDriver();
	   driver.get("http://monster.com");
	   driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
	   Thread.sleep(2000);
	   
	   WebElement uploadResume=  driver.findElement(By.id("file-upload"));
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click()", uploadResume);
	   
	   //Call our AutoItScript Here
	   Runtime.getRuntime().exec("C:\\Users\\aksha\\OneDrive\\Desktop\\TextFileToBeUpload.exe");
	   Thread.sleep(3000);
	 //  driver.close();
   }
}
