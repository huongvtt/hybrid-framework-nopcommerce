package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir"); 
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case CHROME:
			break;
		case EDGE:
			break;
		case FIREFOX:
			break;
		case OPERA:
			break;
		}
				
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
}
