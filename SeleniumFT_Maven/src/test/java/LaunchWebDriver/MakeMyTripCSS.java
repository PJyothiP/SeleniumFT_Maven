package LaunchWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCSS {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		List<WebElement> li = driver.findElements(By.cssSelector("span[class^='false']"));
		for (WebElement webElement : li) {
			if(webElement.getText().equals("Flights")) {
				je.executeScript("arguments[0].click()", webElement);
			}
			System.out.println(webElement.getText());
		}
	}

}
