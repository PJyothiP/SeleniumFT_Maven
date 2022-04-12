package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidElementStateException {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		driver.findElement(By.name("q")).sendKeys("abc");
		driver.findElement(By.name("q")).click();
		WebElement we = driver.findElement(By.xpath("//div[@class = 'FPdoLc lJ9FBc']//input[@class = 'gNO89b' and @value = 'Google Search']"));
		je.executeScript("arguments[0].click()", we);
		//WebElement depart = driver.findElement(By.xpath("//span[@class = 'lbl_input latoBold appendBottom10' and text()= 'DEPARTURE']"));
		//depart.click();
	}

}
