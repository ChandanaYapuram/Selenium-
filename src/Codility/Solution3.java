package Codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class Solution3 extends WebDriverTestCase{

	@Test
	public void usernameCannotBeEmpty() {
		webDriver.get("https://opensource-demo.orangehrmlive.com/");
		webDriver.findElement(By.id("btnLogin")).click();
		String title = webDriver.findElement(By.xpath("//div[@id='divLoginButton']/span[contains(.,'Username cannot be empty')]")).getText();
		assertEquals("Username cannot be empty",title);
		System.out.println(title);
	}
	@Test
	public void passwordCannotbeEmpty() {
		webDriver.findElement(By.id("txtUsername")).sendKeys("admin");
		webDriver.findElement(By.id("btnLogin")).click();
		String title = webDriver.findElement(By.xpath("//div[@id='divLoginButton']/span[contains(.,'Password cannot be empty')]")).getText();
		assertEquals("Password cannot be empty",title);
		System.out.println(title);
	}
	@Test
	public void invalid() {
		webDriver.findElement(By.id("txtUsername")).clear();
		webDriver.findElement(By.id("txtUsername")).sendKeys("admin");
		webDriver.findElement(By.name("txtPassword")).sendKeys("admin12345");
		webDriver.findElement(By.id("btnLogin")).click();
		String title = webDriver.findElement(By.xpath("//div[@id='divLoginButton']/span[contains(.,'Invalid credentials')]")).getText();
		assertEquals("Invalid credentials",title);
		System.out.println(title);
	}
	}

