package se2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Sai%20Teja/Desktop/iframe.html");
		
		driver.switchTo().frame("Front");	//Passing id of iframe
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.switchTo().defaultContent();	//For coming to Original Page
		Thread.sleep(2000);
		
		driver.switchTo().frame(1);
		driver.findElement(By.name("q")).sendKeys("admin");
		driver.switchTo().defaultContent();	//For coming to Original Page
		Thread.sleep(2000);
		
		WebElement thirdFrame = driver.findElement(By.className("dummy"));
		driver.switchTo().frame(thirdFrame);
		driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}
