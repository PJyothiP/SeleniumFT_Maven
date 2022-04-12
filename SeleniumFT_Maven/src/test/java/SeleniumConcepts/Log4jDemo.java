package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4jDemo {

	public static final Logger log = Logger.getLogger(Log4jDemo.class);
	public static void main(String[] args) throws IOException {
		
		FileInputStream fi = new FileInputStream("C:\\Users\\lcharith.ORADEV\\eclipse-workspace\\SeleniumFT_Maven\\src\\main\\resources\\log4j.properties");
		Properties prop = new Properties();
		prop.load(fi);
		System.out.println(prop.getProperty("log4j.appender.console"));
		System.out.println(log.getName());
		WebDriverManager.firefoxdriver().setup();
		log.info("Successfully completed webdriver manager");
		WebDriver driver = new FirefoxDriver();
		log.info("launched chrome browser");
		driver.get("https://www.amazon.com");
		log.info("amazon website is displayed");
		if(driver.getTitle().equals("Amazon.com. Spend less. Smile ")){
			log.info("amazon page is launced");
		}else {
			log.error("Unable to launch amazon");
		}
		
	}

}
