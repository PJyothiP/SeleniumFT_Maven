package SeleniumConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		List<WebElement> li = driver.findElements(By.tagName("a")).stream().filter(x->!x.getText().isEmpty()).collect(Collectors.toList());
		for (WebElement webElement : li) {
			if(webElement.getAttribute("href") != null && (webElement.getAttribute("href").startsWith("http"))) {
				System.out.println(webElement.getAttribute("href"));
				HttpURLConnection connection = (HttpURLConnection)new URL(webElement.getAttribute("href")).openConnection();
				connection.connect();
				int response = connection.getResponseCode();
				String responseMsg = connection.getResponseMessage();
				System.out.println(response+ " and response message is : "+responseMsg);
				if(response == 404) {
					System.out.println("The link is broken :"+webElement.getAttribute("href"));
				}
			}
		}
	}

}
