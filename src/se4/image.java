package se4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Open Orangehrm
 * Get total available images on login page
 * Write the links(from where images are coming) into second sheet of WorkBook
 */

public class image {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://opensource-demo.orangehrmlive.com");
		
		List<WebElement> allImgs= driver.findElements(By.tagName("img"));
		int sz= allImgs.size();
		System.out.println("Total available images are"+ sz);
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\Sai Teja\\Desktop\\data.xls"));
		HSSFSheet sh = wb.getSheet("Sheet1");
		
		
		
		for(int i=0;i<sz;i++) {
			System.out.println(allImgs.get(i).getAttribute("src"));
			sh.createRow(i).createCell(0).setCellValue(allImgs.get(i).getAttribute("src"));
		}
		wb.write(new FileOutputStream("C:\\Users\\Sai Teja\\Desktop\\data.xls"));
	}

}