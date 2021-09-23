package se1;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class first {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		FirefoxDriver driver= new FirefoxDriver();
		
		driver.get("https://www.instagram.com");
		@SuppressWarnings("unused")
		String title=driver.getTitle();
		System.out.println("Successfully opened "+title+" Page");
		Thread.sleep(10000);
		driver.quit();
	}

}
