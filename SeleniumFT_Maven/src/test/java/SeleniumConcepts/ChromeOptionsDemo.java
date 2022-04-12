package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo {

	public static void main(String[] args) {
		DesiredCapabilities dc = new DesiredCapabilities();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		System.out.println("Setting of Incognito mode is done");
		co.addArguments("start-maximized");
		System.out.println("Window maximize is successful");
		co.merge(dc);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		System.out.println("successfully launched the browser");
		driver.get("https://www.amaz.com");
		if(driver.getTitle().equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("Successfully launched amazon");
		}else {
			System.out.println("Unable to launch amazon");
		}
		
	}

}
