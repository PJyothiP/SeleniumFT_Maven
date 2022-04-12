package SeleniumConcepts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAutoITDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/lcharith.ORADEV/Documents/Charitha/SeleniumFT/autoIT.html");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input")).sendKeys("C:\\Users\\lcharith.ORADEV\\Documents\\Charitha\\SeleniumFT\\Session 10\\Screenshot.JPG");
		Thread.sleep(3000);
		WebElement browse = driver.findElement(By.xpath("//input"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", browse);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\lcharith.ORADEV\\Documents\\Charitha\\SeleniumFT\\Session 11\\UploadFileAutoIT.exe");
		System.out.println("After running");
		download();
	}

	private static void download() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\lcharith.ORADEV\\Documents\\Charitha\\SeleniumFT\\Session 11\\DownloadFileAutoIT.exe");
		
	}
	

}
