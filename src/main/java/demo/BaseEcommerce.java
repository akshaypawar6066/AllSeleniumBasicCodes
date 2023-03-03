package demo;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseEcommerce
{
	public static void main(String[] args) throws InterruptedException
	{
		String[] iteamNeeded = { "Cucumber", "Brocolli", "Beetroot", "Beans" };
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addIteams(driver, iteamNeeded);

	}

	public static void addIteams(WebDriver driver, String[] iteamNeeded) throws InterruptedException {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) 
		{
			List<String> iteamNeededToAdd = Arrays.asList(iteamNeeded);
			String name = products.get(i).getText();
			String nameArray[] = name.split("-");
			String nameOfVegetable = nameArray[0].trim();

			if (iteamNeededToAdd.contains(nameOfVegetable))
			{
				j++;

				// Check name you extracted is present in array or not
				// ArrayList has contains method & we can convert Array into arrayList(for easy
				// search)
				// check whether name is present in the ArrayList or not.
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == iteamNeeded.length) {
					break;
				}
			}

		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div//header/div/div/div/div[2]/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// ***Explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.findElement(By.xpath("(//div)[7]/button")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@style='width: 200px;']")));
		select.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.close();

	}
}
