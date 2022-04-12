package LaunchWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebDriverDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
	}
}
