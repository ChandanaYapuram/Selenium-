package se3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get( "https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Actions a = new Actions(driver);	//Actions class is for working with MouseHover and keyboard controlling
		WebElement r = driver.findElement(By.linkText("Recruitment"));
		a.moveToElement(r).perform();
		a.click(driver.findElement(By.linkText("Candidates"))).perform();
		driver.quit();
	}

}
