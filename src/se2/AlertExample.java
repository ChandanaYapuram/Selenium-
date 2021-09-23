package se2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
		

		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		
		Alert a=driver.switchTo().alert();   // Focusing to Alert
		
		System.out.println(a.getText());  //It will print text which is there inside alert
		
		a.sendKeys("LTI");  // For Typing 
		
		a.accept(); // For Clicking on OK button
		a.dismiss();  // For Clicking on Cancel Button
	}
}