package se2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmCSS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//tagname#id
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		//tagname[name/type/value='prop value']
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		//tagname[name/type/value='prop value'
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		//tagname.className
		driver.findElement(By.cssSelector("a.panelTrigger")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
		driver.quit();
	}

}
