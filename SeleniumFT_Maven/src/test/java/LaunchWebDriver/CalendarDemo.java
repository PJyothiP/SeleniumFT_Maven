package LaunchWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor je = (JavascriptExecutor)driver;
		driver.get("https://www.makemytrip.com");
		WebElement depart = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
		je.executeScript("arguments[0].click()", depart);
		Thread.sleep(5000);
		List<WebElement> li = driver.findElements(By.
				xpath("//div[@class = 'DayPicker-Day' or @class = 'DayPicker-Day DayPicker-Day--today' or @class = 'DayPicker-Day DayPicker-Day--selected']"));
		System.out.println(li.size());
		for (WebElement webElement : li) {
			System.out.println(webElement.getAttribute("aria-label"));
			if(webElement.getAttribute("aria-label").contains("Apr 12")) {
				je.executeScript("arguments[0].click()", webElement);
				break;
			}
		}
	}
}
