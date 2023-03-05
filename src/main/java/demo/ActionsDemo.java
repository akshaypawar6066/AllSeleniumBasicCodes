package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/gp/css/homepage.html/ref=nav_bb_ya");
		Actions act=new Actions(driver);
		WebElement yourAccount=driver.findElement(By.id("nav-link-accountList"));
		act.moveToElement(yourAccount).perform();
		WebElement accounSetting=driver.findElement(By.xpath("(//a[@class=\"nav-link nav-item\"])[3]"));
		act.moveToElement(accounSetting).click().build().perform();
		WebElement serachBox=driver.findElement(By.id("twotabsearchtextbox"));
	   act.moveToElement(serachBox).click().keyDown(Keys.SHIFT).sendKeys("akshay pawar").doubleClick().click().perform();
//		serachBox.sendKeys(Keys.SHIFT,"apple");
//		serachBox.sendKeys(Keys.ENTER);
	   System.out.println("Hello");
	   
	  
	   
	     	 

	}
}
