package se4;

import org.testng.annotations.Test;

import fm.Excel;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@SuppressWarnings("unused")
public class ExcelDataDriven {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void loginTest(String user, String pwd) throws Exception{
	  	driver.get( "https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
  }
  
  @BeforeTest	//Pre-condition > Something which need to be done at starting
  public void beforeTest() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @DataProvider
  public Object[][] dp() throws Exception{
//	  HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream("C:\\Users\\Sai Teja\\Desktop\\Book1.xls"));
//	  HSSFSheet sh=wb.getSheet("Sheet1");
	  Excel ex=new Excel("C:\\Users\\Sai Teja\\Desktop\\Book1.xls");
	  //Object data[][]=new Object[4][2];
	  Object data[][]=new Object[ex.getRowNum("Sheet1")][ex.getColNum("Sheet1")];
	  for(int i=0;i<data.length;i++) {
//		  data[i][0]=sh.getRow(i).getCell(0).toString();
//		  data[i][1]=sh.getRow(i).getCell(1).toString();
		  data[i][0]=ex.getData("Sheet1", i, 0);	//taking username of specific row
		  data[i][1]=ex.getData("Sheet1", i, 1);	//taking password
		  
	  }
	return data;
  }
 
}