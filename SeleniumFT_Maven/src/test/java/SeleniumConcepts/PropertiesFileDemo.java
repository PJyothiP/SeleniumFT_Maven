package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFileDemo {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileInputStream fi = new FileInputStream(".\\config\\configuration.properties");
		Properties p = new Properties();
		p.load(fi);
		String browser = p.getProperty("browserName");
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default :
			System.out.println("invalid browser type");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(p.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.get(p.getProperty("URL"));
		
	}

}
