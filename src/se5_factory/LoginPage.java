package se5_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name="txtUsername") WebElement e_user;
	@FindBy(id="txtPassword") WebElement e_pwd;
	@FindBy(id="btnLogin") WebElement e_login;
	@FindBy(linkText="Forgot your password?") WebElement e_forget;
	
	public void setUserName(String user) {
		e_user.sendKeys(user);
	}
	public void setPassword(String pwd) {
		e_pwd.sendKeys(pwd);
	}
	public void clickLogin() {
		e_login.click();
	}
	public void doLogin(String user,String pwd) {
		setUserName(user);
		setPassword(pwd);
		clickLogin();
	}
	public void forget() {
		e_forget.click();
	}
}
