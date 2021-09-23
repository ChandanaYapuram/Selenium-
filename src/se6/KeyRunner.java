package se6;

import org.testng.annotations.Test;

import fm.Excel;
import fm.base;
import fm.keywords;

import org.testng.annotations.DataProvider;

public class KeyRunner extends base{
  @Test(dataProvider = "dp")
  public void excelKeyRunner(String exKey,String locatorType,String locatorValue,String data) {
	  keywords key=new keywords(driver);
	  if(exKey.equals("getURL"))
		  key.getURL(data);
	  else if(exKey.equals("click"))
		  key.click(locatorType, locatorValue);
	  else if(exKey.equals("selectFromDropDown"))
		  key.selectFromDropDown(locatorType, locatorValue, data);
	  else if(exKey.contentEquals("selectToDropDown"))
		  key.selectToDropDown(locatorType, locatorValue, data);
	  else if(exKey.equals("getSnap"))
		  key.getSnap(data);
	  else
		  System.out.println("Invalid Key");
  }

  @DataProvider
  public Object[][] dp() {
	  Excel ex=new Excel("C:\\Users\\Sai Teja\\Desktop\\book2.xlsx");
	  Object data[][]=new Object[ex.getRowNum("Sheet5")-1][ex.getColNum("Sheet5")];
	  for(int i=0;i<data.length;i++) {
		  data[i][0]=ex.getData("Sheet5", i+1, 0);
		  data[i][1]=ex.getData("Sheet5", i+1, 1);
		  data[i][2]=ex.getData("Sheet5", i+1, 2);
		  data[i][3]=ex.getData("Sheet5", i+1, 3);
	  }
	  return data;
  }
}
