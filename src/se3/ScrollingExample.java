package se3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingExample {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		WebElement E=driver.findElement(By.linkText("@diegofmolina"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;	//driver is converted into javascriptexecutor type
		//Scrolling till particular object
		js.executeScript("arguments[0].scrollIntoView();", E);	
		
		//Scrolling Pixel By Pixel
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		
		//For Scrolling bottom of the Page
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.quit();
	}

}
