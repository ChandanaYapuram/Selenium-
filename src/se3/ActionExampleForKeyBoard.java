package se3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExampleForKeyBoard {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://bing.com");
		
		WebElement searchField=driver.findElement(By.id("sb_form_q"));
		Actions ac=new Actions(driver);
		ac.keyDown(Keys.SHIFT)
		  .sendKeys(searchField,"lti")
		  .doubleClick(searchField)
		  .contextClick(searchField)
		  .perform();
		Thread.sleep(2000);
	}

}
