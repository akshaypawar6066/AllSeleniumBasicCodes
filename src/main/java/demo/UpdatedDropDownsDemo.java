package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatedDropDownsDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		Thread.sleep(1000);
		WebElement addAdult = driver.findElement(By.id("hrefIncAdt"));
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
		int i = 1;
		while (i < 5) {
			addAdult.click();
			i++;
		}
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
	}
}
