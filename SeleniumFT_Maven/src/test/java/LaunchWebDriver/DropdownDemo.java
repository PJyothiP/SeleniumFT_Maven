package LaunchWebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		
		
		Select s = new Select(dropDown);
		//s.selectByIndex(4);
		//s.selectByValue("search-alias=arts-crafts-intl-ship");
		s.selectByVisibleText("Computers");
		
		
//		dropDown.click();
//		List<WebElement> li = driver.findElements(By.xpath("//select[@id = 'searchDropdownBox']//option"));
//		for (WebElement webElement : li) {
//			System.out.println(webElement.getText());
//			if(webElement.getText().equals("Computers")) {
//				webElement.click();
//			}
//		}
	}

}
