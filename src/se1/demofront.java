package se1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demofront {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get( "http://demo.frontaccounting.eu/");
		WebElement us = driver.findElement(By.name("user_name_entry_field"));
		us.clear();
		us.sendKeys("demouser");
		
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("password");
		//driver.findElement(By.name("user_name_entry_field")).clear();
		//driver.findElement(By.name("password")).clear();
		//driver.findElement(By.name("user_name_entry_field")).sendKeys("demouser");
		//driver.findElement(By.name("password")).sendKeys("password");
		
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
