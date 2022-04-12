package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/lcharith.ORADEV/Documents/Charitha/SeleniumFT/Session%2010/frames.html");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.linkText("Charity supporting the Ukrainian army")).click();
		
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		
		
	}

}
