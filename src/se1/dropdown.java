package se1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://blazedemo.com");
		WebElement fp = driver.findElement(By.name("fromPort"));
		Select s1 = new Select(fp);
		
		s1.selectByVisibleText("Paris");
		Thread.sleep(2000);
		
		s1.selectByIndex(5);
		Thread.sleep(2000);
		
		s1.selectByValue("Boston");
		Thread.sleep(2000);
		driver.quit();
	}

}
