package se5_factory;

import org.testng.annotations.Test;

import se5_pom.LoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class factory {
	WebDriver driver;
  @Test
  public void forgetLinkTest() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
	  lp.forget();
	  Assert.assertEquals(driver.getCurrentUrl().contains("requestPasswordResetCode"),true);
  }
  
  @Test
  public void loginTest() throws Exception{
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  //WebDriverWait wt=new WebDriverWait(driver,20);
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
	  lp.doLogin("admin","admin123");
	  Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"),true);
	  driver.findElement(By.id("welcome")).click();
	  //Thread.sleep(2000);
	  //wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout123")));
	  driver.findElement(By.linkText("Logout"));
  }
  
  @BeforeTest	//Pre-condition > Something which need to be done at starting
  @Parameters("browser")
  public void beforeTest(String browser) {
	  if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver=new ChromeDriver();
	  } else if(browser.equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		  driver=new FirefoxDriver();
	  }else {
		  System.out.println("Invalid Browser");
	  }
  }

  @AfterTest	// Post-condition > Something which need to be done at the End
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
