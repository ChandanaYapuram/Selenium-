package se6;

import org.testng.annotations.Test;

import fm.base;
import fm.keywords;

public class Runner extends base{
  @Test
  public void f() {
	  keywords key=new keywords(driver);
	  key.getURL("http://blazedemo.com");
//	  key.sendKeys("name", "email", "abc@gmail.com");
//	  key.click("name","login");
	  key.getSnap("drivers/blaze.png");
	  key.selectFromDropDown("name","fromPort" ,"Paris");
	  key.selectFromDropDown("name", "toPort", "Rome");
  }
}
