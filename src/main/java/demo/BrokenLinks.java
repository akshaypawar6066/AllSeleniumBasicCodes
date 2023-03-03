package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// *** Broken Link or Broken URL--->URL to that link is not working ***///

		// 1st step-Get all the URLS tide up with the links using the selenium
		// 2nd step-There are some java methods which calls all the URL's and get status
		// code
		// 3rd step-If status code >400 then that url is not working-> Link tied up that url is not working
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			System.out.println(url);
			System.out.println(link.getText());
			URL urlObject=new URL(url);
			HttpURLConnection conn=(HttpURLConnection)urlObject.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int reponseCode=conn.getResponseCode();
			softAssert.assertTrue(reponseCode<=400,"The link with Text "+link.getText()+" is brokened with status code "+reponseCode);
			
		}
		softAssert.assertAll();

//		Iterator<WebElement> it = links.iterator();
//		while (it.hasNext()) {
//
//			String url = it.next().getAttribute("href");
//			System.out.println(url);
//			System.out.println(it.next().getText());
//		
//			URL urlObject=new URL(url);
//			HttpURLConnection conn=(HttpURLConnection)urlObject.openConnection();
//			conn.setRequestMethod("HEAD");
//			conn.connect();
//			int reponseCode=conn.getResponseCode();
//			if(reponseCode>400)
//			{
//				
//				System.out.println("The link with Text "+it.next().getText()+"is brokened with status code "+reponseCode);
//			}
//
//		}
	}
}
