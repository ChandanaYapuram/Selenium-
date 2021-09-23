package se6;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkImageTesting {
	WebDriver driver;
	Properties prop;
	@Test
	public void linkTest() throws Exception {
		//driver.get(prop.getProperty("url"));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			String href = links.get(i).getAttribute("href");
			//System.out.println(href);
			URL url = new URL(href);
			// This will open Channel for Connection ..Will not do Actual Connection
			URLConnection con = url.openConnection();
			HttpURLConnection httpCon = (HttpURLConnection) con; // Http related methods are present in httpUrlConnection
			httpCon.connect();  //This will do Actual Connection
			int code = httpCon.getResponseCode();
			if (code == 200)
				System.out.println(url + " working");
			else
				System.out.println(url +" Not Working "+code);
		}
	}
	@BeforeTest
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--headless");  // Chrome will Start but it will not be visible to you.
		driver = new ChromeDriver(op);
		prop = new Properties();
		prop.load(new FileInputStream("settings.property"));
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}