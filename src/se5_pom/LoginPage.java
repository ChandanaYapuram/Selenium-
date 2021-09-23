package se5_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;		//	Driver initialization process
	}
	By e_userName = By.name("txtUsername");
	By e_pwd = By.id("txtPassword");
	By e_login = By.id("btnLogin");
	By e_forget = By.linkText("Forgot your password?");
	
	public void setUserName(String user) {
		driver.findElement(e_userName).sendKeys(user);
	}
	public void setPassword(String pwd) {
		driver.findElement(e_pwd).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(e_login).click();
	}
	public void doLogin(String user,String pwd) {
		setUserName(user);
		setPassword(pwd);
		clickLogin();
	}
	public void forget() {
		driver.findElement(e_forget).click();
	}
}
