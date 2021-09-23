package se6;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyExample {
  @Test
  public void readProperty() throws Exception{
	  Properties prop=new Properties();
	  prop.load(new FileInputStream("settings.property"));
	  
	  System.out.println(prop.getProperty("url"));
	  System.out.println(prop.get("e_logout"));
  }
}
