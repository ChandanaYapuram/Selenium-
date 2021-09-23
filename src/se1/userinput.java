package se1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Scanner;

public class userinput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 for Chrome"+"\n"+ "Enter 2 for Firefox");
		int opt = s.nextInt();
		
		WebDriver driver =null;
		if(opt==1){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver= new ChromeDriver();
			}
		else if(opt==2){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("enter valid option");
		}
		if(driver!=null) {
			driver.get("https://www.gmail.com");
			String title=driver.getTitle();
			System.out.println("Successfully opened "+title+" Page");
			Thread.sleep(2000);
			driver.quit();
		}
		s.close();
	}

}
