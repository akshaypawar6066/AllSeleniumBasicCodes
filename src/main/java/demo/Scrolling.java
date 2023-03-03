package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {
	public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
//		WebElement scroll=driver.findElement(By.id("mousehover"));
//		js.executeScript("arguments[0].scrollIntoView(true)", scroll);
		Thread.sleep(2000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollBy(0,200)");

	}
}
