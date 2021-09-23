package se3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingExcelOrange {

	public static void main(String[] args) throws Exception{
		HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream("C:\\Users\\Sai Teja\\Desktop\\data1.xls"));
		
		//2.Reading Sheet
		HSSFSheet sh=wb.getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get( "https://opensource-demo.orangehrmlive.com/");
		System.out.println("Number of rows "+sh.getLastRowNum());	//Index of last row will be given
		System.out.println("Number of columns "+sh.getRow(0).getLastCellNum());
		for(int i=0;i<=3;i++) {
			String user=sh.getRow(i).getCell(0).toString();
			System.out.print(user+" ");
			
			String pwd=sh.getRow(i).getCell(1).toString();
			System.out.println(pwd);
			
			driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(user);
		    driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		    driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		    
		    if(driver.getCurrentUrl().contains("dashboard")) {
		    	driver.findElement(By.cssSelector("a.panelTrigger")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
				sh.getRow(i).createCell(2).setCellValue("PASSED");
		    }
		    else {
		    	sh.getRow(i).createCell(2).setCellValue("FAILED");
		    }
		}
		wb.write(new FileOutputStream("C:\\Users\\Sai Teja\\Desktop\\data3.xls"));
		driver.quit();
	}
}
