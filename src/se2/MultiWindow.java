package se2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindow {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com");
		
		String pid=driver.getWindowHandle(); // Getting id of currently highlighted tab/window,pid=parent window id
		System.out.println("Parent Window Id "+pid);
		
		Set<String> allwin=driver.getWindowHandles(); // Getting id of ALL Windows/tab
		
/*		for(String id : allwin) {  //It works for every value in set/array/list
			System.out.println(id);
			if(!id.contentEquals(pid)) { 	//If it is not a parent id(If it is child id)
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();	//It is for closing highlighted window
			}
		}*/
		List<String> allWin2=new ArrayList<>(allwin); //converting set into list
		driver.switchTo().window(allWin2.get(3));
		System.out.println("Second Window Title is :" +driver.getTitle());
		
		for(int i=0;i<allWin2.size();i++) {
			String id = allWin2.get(i);
			if(!id.contentEquals(pid)) { 	//If it is not a parent id(If it is child id)
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();	//It is for closing highlighted window
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
