package se2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		List<WebElement> l = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links available "+ l.size());
		
		for(int i=0;i<l.size();i++) {
			System.out.println(i+1 +" link have href as "+l.get(i).getAttribute("href"));
			//System.out.println(l.get(i).getAttribute("href"));
		}
	}

}
