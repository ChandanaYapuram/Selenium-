package se4;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void loginTest(String user, String pwd) throws Exception{
	  driver.get( "http://demo.frontaccounting.eu/");
		WebElement us = driver.findElement(By.name("user_name_entry_field"));
		us.clear();
		us.sendKeys(user);
		
		WebElement pd = driver.findElement(By.name("password"));
		pd.clear();
		pd.sendKeys(pwd);
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(5000);
		/*driver.get( "https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();*/
  }
  @BeforeTest	//Pre-condition > Something which need to be done at starting
  public void beforeTest() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @DataProvider
  public Object[][] dp() {
    Object data[][]=new Object[4][2];
    data[0][0]="admin";
    data[0][1]="admin123";
    data[1][0]="demouser";
    data[1][1]="password";
    data[2][0]="hr";
    data[2][1]="hr123";
    data[3][0]="abc";
    data[3][1]="abc123";
    return data;
  }
}