package se3;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;

public class jdbc 
{
	public static void main(String[] args) throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from info");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		while(rs.next())
		{		
			
			String a=rs.getString(1);
			String b=rs.getString(2);
			
			System.out.println(a+ " "+b);
			
			driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(a);
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(b);
			
			driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				driver.findElement(By.cssSelector("a.panelTrigger")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
		        System.out.println("LOGIN PASSED");
			}
			else {
				System.out.println("LOGIN FAILED");
			}
		
		}
		rs.close();
		con.close();
		driver.quit();

	}



	}