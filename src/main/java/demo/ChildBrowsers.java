package demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildBrowsers {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        String userName="";
       String parentAddress= driver.getWindowHandle();
        //ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles()); //Convert values of set<String> into ArrayList.  
         Set<String> addresses=driver.getWindowHandles();
        Iterator<String> it= addresses.iterator();
        while(it.hasNext())
        {
        	driver.switchTo().window(it.next());
        	if(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/documents-request"))
        	{
        		userName=driver.findElement(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")).getText();
        	}
        }
        driver.switchTo().window(parentAddress); 
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys(userName);
	}
}
