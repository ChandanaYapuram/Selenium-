package se3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionBuild {

	public static void main(String[] args) throws Exception{

		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://bing.com");
		WebElement search=driver.findElement(By.name("q"));
		
		Actions ac=new Actions(driver);
		
		Action act=ac.keyDown(Keys.SHIFT)
		  .sendKeys(search,"lti")
		  .doubleClick(search)
		  .contextClick(search)
		  .build();
		
		act.perform();
		Thread.sleep(2000);
		driver.quit();
	}

}
