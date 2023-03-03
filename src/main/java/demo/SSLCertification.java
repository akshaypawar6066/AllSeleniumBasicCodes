package demo;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertification {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options =new ChromeOptions();   //To set behavior of the browser
        //FirefoxOptions fOptions=new FirefoxOptions()
        //EdgeOptions edgeOptions=new EdgeOptions();
        // Proxy proxy=new Proxy();
        //proxy.setHttpProxy("ipaddress:8080");
        //options.setCapability("proxy", proxy);
		 options.addArguments("--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
