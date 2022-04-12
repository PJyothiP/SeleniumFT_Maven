package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseKeyboardEventsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Thread.sleep(5000);
		
		//Mouse Event
		WebElement account = driver.findElement(By.xpath("//span[@class = 'nav-line-2 ' and text()='Account & Lists']"));
		Actions a = new Actions(driver);
		a.moveToElement(account).build().perform();
		WebElement ac = driver.findElement(By.xpath("//span[@class='nav-text' and text()='Account']"));
		ac.click();
		
		//Keyboard Event
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		a.keyDown(input,Keys.SHIFT).sendKeys("books").build().perform();
		a.keyUp(input, Keys.SHIFT).build().perform();
	}

}
