package LaunchWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsAmazonDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		//driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("Books");
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		//Thread.sleep(20000);
		//driver.findElement(By.xpath("//div[text() = 'Greenlights']")).click();
		//handle a checkbox using the display text
		driver.findElement(By.cssSelector("img[alt='Beauty picks']")).click();
		WebElement check = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text() = 'Unscented']//preceding-sibling::div//i"));
		if(!check.isSelected()) {
			check.click();
		}
		WebElement check1 = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text() = 'Unscented']//preceding-sibling::div//i"));
		
	}
}
