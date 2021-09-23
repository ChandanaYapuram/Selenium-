package se2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EaseMyTrip {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	//for maximizing window
		driver.get("https://www.easemytrip.com");
		
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("spn3")).click();
		
		driver.findElement(By.cssSelector("input[onclick='SearchFlightWithArmy();']")).click();
		
		Alert ac = driver.switchTo().alert();
		System.out.println(ac.getText());
		ac.accept();
		Thread.sleep(2000);
		driver.quit();
	}

}
