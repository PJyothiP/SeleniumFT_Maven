package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementExceptiondemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebElement we = driver.findElement(By.id("identifierId"));
		System.out.println(we.getAttribute("name"));
		System.out.println("----page getting refreshed manually ------------");
		try{
			we.sendKeys("abc");
		}catch(StaleElementReferenceException e) {
			System.out.println("Inside catch block");
			driver.findElement(By.id("identifierId")).sendKeys("abc");
		}
	}

}
