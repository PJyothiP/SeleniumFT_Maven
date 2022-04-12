package LaunchWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
//		//locate using id
//		WebElement username = driver.findElement(By.id("identifierId"));
//		//perform action
//		username.sendKeys("charitha.lebaka56");
		
		//locate using name
		//driver.findElement(By.name("identifier")).sendKeys("charitha.lebaka56");
		//locate using linktext 
		//driver.findElement(By.linkText("Help")).click();
		//locate using partial link text
		//driver.findElement(By.partialLinkText("Learn")).click();
		//locate using class name 
		//driver.findElement(By.className("whsOnd")).sendKeys("xyz");
		//locate using tagname
		
		List<WebElement> li = driver.findElements(By.tagName("a"));
		for (WebElement webElement : li) {
			System.out.println(webElement.getText());
		}
		
		//locate using xpath
		driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("abc");
		
		//driver.quit();
	}

}
