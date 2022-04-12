package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetExplorerOptionsDemo {

	public static void main(String[] args) {
		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setAcceptInsecureCerts(true);
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//dc.acceptInsecureCerts();
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		InternetExplorerOptions ieo = new InternetExplorerOptions();
		ieo.ignoreZoomSettings();
		ieo.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		System.out.println("this is capabilty : "+ieo.getCapability(CapabilityType.ACCEPT_SSL_CERTS));
		ieo.merge(dc);
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(ieo);
		driver.get("https://expired.badssl.com");
	}

}
