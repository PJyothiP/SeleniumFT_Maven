package LaunchWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		WebElement train = driver.findElement(By.xpath("//span[@class = 'false chNavText darkGreyText' and text() = 'Trains']"));
		//train.click();
		//je.executeScript("arguments[0].click()",train);
		List<WebElement> li = driver
			.findElements(
					By.xpath("//span[@class = 'false chNavText darkGreyText' and text() = 'Trains']//ancestor::li[@class='menu_Trains']//preceding-sibling::li"));
		for (WebElement webElement : li) {
			System.out.println(webElement.getAttribute("data-cy"));
		}
		
		String text = driver.findElement(By.xpath("//li[@class = 'menu_Trains']//descendant::span[@class = 'false chNavText darkGreyText']")).getText();
		System.out.println("The display text is : "+text);
		
		//Handle radio button
		
		WebElement round = driver.findElement(By.xpath("//li[text()='Round Trip']"));
		
		
		if(!round.getAttribute("class").equals("selected")) {
			je.executeScript("arguments[0].click()", round);
		}
		
//		if(!round.isSelected())
//		{
//			je.executeScript("arguments[0].click()", round);
//		}
	}

}
