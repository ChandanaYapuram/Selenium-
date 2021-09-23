package se4Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJunitTest {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Before");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After");
		Thread.sleep(2000);
		driver.quit();
		
	}

	@Test
	public void test() {
		System.out.println("Test");
		driver.get("http://instagram.com");
		String actualTitle=driver.getTitle();
		assertEquals("Instagram",actualTitle);
		
	}

}
