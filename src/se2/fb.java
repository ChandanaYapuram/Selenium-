package se2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fb {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Waits for Visibility of object and should be declared only once
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.cssSelector("input[value='1']")).click();
		Thread.sleep(2000);
		//findElements used to group the objects with common property and it returns List<WebElement>

		List<WebElement> ls = driver.findElements(By.name("sex"));
		
		System.out.println("Total radio options are "+ls.size());
		ls.get(1).click();
		
		for(int i=0;i<ls.size();i++) {
			Thread.sleep(2000);
			ls.get(i).click();
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
