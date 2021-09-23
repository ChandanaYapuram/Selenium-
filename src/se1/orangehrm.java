package se1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrm {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get( "https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
