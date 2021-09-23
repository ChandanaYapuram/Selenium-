package se4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FirstScriptNG {
	WebDriver driver;
  @Test(priority=1,description="Verifying title of search page")
  public void googleTitleTest() {	//All testing related activity should be kept here
	  System.out.println("Test 1");
	  driver.get("http://google.com");
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle,"Google ");
  }
  
  @Test(priority=2,description="Verifying title of search resultpage")
  public void googleSearchTest() {	//All testing related activity should be kept here
	  System.out.println("Test 2");
	  driver.findElement(By.name("q")).sendKeys("LTI");
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle,"LTI - Google Search");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
  
  @AfterMethod
  public void afterMethod(ITestResult response) throws Exception {
	  System.out.println("After Method");
	  if(response.getStatus()==ITestResult.FAILURE) {
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(response.getName()+" .png"));	  
	  }
  }
  
  @BeforeTest	//Pre-condition > Something which need to be done at starting
  public void beforeTest() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest	// Post-condition > Something which need to be done at the End
  public void afterTest() throws Exception {
	  System.out.println("After Test");
	  Thread.sleep(2000);
	  driver.quit();
  }

}
