package se4Junit;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class ColorTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://blazedemo.com");
		WebElement E= driver.findElement(By.cssSelector("input[value='Find Flights']"));
		String backColor= E.getCssValue("background-color");
		System.out.println("backcolor: " +backColor);
		
		String backColorHex= Color.fromString(backColor).asHex();
		
		System.out.println("backColorHex: "+backColorHex);
		assertEquals("#006dcc", backColorHex);
	}

}