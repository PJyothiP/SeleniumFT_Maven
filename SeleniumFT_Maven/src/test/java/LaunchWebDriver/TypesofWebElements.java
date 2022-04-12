package LaunchWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypesofWebElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		WebElement username = driver.findElement(By.id("identifierId"));
		je.executeScript("arguments[0].value = 'charitha.lebaka56'", username);
		WebElement next = driver
				.findElement(By
						.cssSelector(".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qfvgSe.qIypjc.TrZEUc.lw1w4b"));
		je.executeScript("arguments[0].click()", next);
		
	}

}
