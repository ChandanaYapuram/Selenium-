package se2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class blazeDemoCSS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://blazedemo.com");
		WebElement fp=driver.findElement(By.cssSelector("select[name='fromPort']"));
		Select s1 = new Select(fp);
		s1.selectByVisibleText("Boston");
		Thread.sleep(2000);
		
		WebElement dp=driver.findElement(By.cssSelector("select[name='toPort']"));
		Select s2 = new Select(dp);
		s2.selectByVisibleText("London");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		List<WebElement> ls = driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
		ls.get(2).click();
		System.out.println("No of flights available are "+ls.size());
		//driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		
		driver.findElement(By.cssSelector("input[name='inputName']")).sendKeys("Chandana");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("234");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Hyd");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("TS");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='zipCode']")).sendKeys("50");
		Thread.sleep(1000);
		WebElement ct=driver.findElement(By.cssSelector("select[name='cardType']"));
		Select s3 = new Select(ct);
		s3.selectByVisibleText("American Express");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2021");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='nameOnCard']")).sendKeys("Chandana");
		Thread.sleep(1000);
		WebElement E =driver.findElement(By.cssSelector("input[name='rememberMe']"));
		
		boolean x= E.isSelected();
		boolean y= E.isDisplayed();
		boolean z= E.isEnabled();
		
		System.out.println("Selection is "+x);
		System.out.println("display is "+y);
		System.out.println("enable is "+z);
		Thread.sleep(1000);
		
		E.click(); 
		
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
