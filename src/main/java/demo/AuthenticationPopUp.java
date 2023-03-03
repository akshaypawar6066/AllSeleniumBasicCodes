package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("http://the-internet.herokuapp.com/basic_auth");
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String text = driver.findElement(By.xpath("//p")).getText();
		System.out.println(text);
	}
}
