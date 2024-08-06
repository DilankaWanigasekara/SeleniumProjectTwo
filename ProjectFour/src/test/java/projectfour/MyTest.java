package projectfour;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Use WebDriverManager to set up the ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Open a https://amazon.in
        driver.get("https://amazon.in");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);	
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterMethod
	public void tearDown() {
	if (driver != null) {
        driver.quit(); //browser will get closed
    }
	}
}
