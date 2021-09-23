package se5_pom;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class POM_Runner {
	WebDriver driver;
	LoginPage lp;
	@Test(description="Checking forget link of login page")
	  public void forgetLinkTest() {
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  lp=new LoginPage(driver);
		  lp.forget();
		  Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	  }
	
	@Test(dependsOnMethods="forgetLinkTest",description="Checking Cancel of login page")
	  public void cancelButtonTest() {
		ForgetPage fp=new ForgetPage(driver);
		fp.doCancel();
		Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
	}
	
	@Test(dependsOnMethods="cancelButtonTest",description="Checking login page")
	  public void LoginTest() {
		lp.doLogin("admin","admin123");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	@BeforeTest	//Pre-condition > Something which need to be done at starting
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver=new ChromeDriver();
	  }

	  @AfterTest	// Post-condition > Something which need to be done at the End
	  public void afterTest() throws Exception {
		  Thread.sleep(2000);
		  driver.quit();
	  }

}
