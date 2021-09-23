package se2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffTASK {
	public static void main (String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://rediff.com");
		driver.switchTo().frame("moneyiframe"); //using through id or frame
		driver.findElement(By.name("query")).sendKeys("Yes Bank LTD");
		driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
		
		List<String> allID = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(allID.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(allID.get(0));
		System.out.println(driver.getTitle());
		driver.quit();
	}

}