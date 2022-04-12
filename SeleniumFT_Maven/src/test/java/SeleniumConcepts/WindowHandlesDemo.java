package SeleniumConcepts;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String parentId = driver.getWindowHandle();
		JavascriptExecutor je = (JavascriptExecutor)driver;
		List<WebElement> li = driver.findElements(By.tagName("a")).stream().filter(x->!x.getText().isEmpty()).collect(Collectors.toList());
		for (WebElement webElement : li) {
			System.out.println(webElement.getText());
		}
		for(int i = 10;i<20;i++) {
			je.executeScript("window.open(arguments[0])", li.get(i).getAttribute("href"));
		}
		Set<String> childId = driver.getWindowHandles();
		for (String string : childId) {
			if(!string.equals(parentId)) {
				driver.switchTo().window(string);
				System.out.println("This is the title of the child window : "+driver.getTitle());
				driver.close();
			}
		}
	}
}
