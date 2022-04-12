package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxOptionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.acceptInsecureCerts();
		//dc.setCapability("AcceptInsecureCerts", false);
		FirefoxOptions fo = new FirefoxOptions();
		fo.setAcceptInsecureCerts(true);
		fo.merge(dc);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(fo);
		driver.manage().deleteAllCookies();
		driver.get("https://expired.badssl.com/");
	}

}
