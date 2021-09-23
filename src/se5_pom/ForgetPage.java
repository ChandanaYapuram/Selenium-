package se5_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage {
	WebDriver driver;
	public ForgetPage(WebDriver driver) {
		this.driver=driver;		//	Driver initialization process
	}
	
	//	Below are Objects Property
	By e_userName = By.name("securityAuthentication[userName]");
	By e_reset = By.id("btnSearchValues");
	By e_cancel = By.id("btnCancel");
	
	//Respective Functions/Methods for Actions
	public void doRest(String userName) {
		driver.findElement(e_userName).sendKeys(userName);
		driver.findElement(e_reset).click();
	}
	public void doCancel() {
		driver.findElement(e_cancel).click();
	}
}
