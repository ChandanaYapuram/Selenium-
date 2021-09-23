package se1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class linktext {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev");
		String title=driver.getTitle();
		System.out.println("You are on "+title+" Page");
		
		driver.findElement(By.linkText("Blog")).click();
		String title2=driver.getTitle(); //It will give you current page title
		System.out.println("You are on "+title2+" Page");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
