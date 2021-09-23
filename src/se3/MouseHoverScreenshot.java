package se3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MouseHoverScreenshot {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Parent p=new Child
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		Actions ac=new Actions(driver); // Actions class is for Working with MouseHover& KeyBoard Controlling
		WebElement perf=driver.findElement(By.linkText("Performance"));
		ac.moveToElement(perf).perform();
	
		ac.click(driver.findElement(By.linkText("My Trackers"))).perform();
		
		TakesScreenshot tc=(TakesScreenshot)driver;   // TypeCasting Conversion of driver to TakesScreenShot happened
		File src=tc.getScreenshotAs(OutputType.FILE);   //After Taking ScreenShot It will store into Java's Buffer Memory
		FileHandler.copy(src, new File("Orange.png"));
		
	}
}
