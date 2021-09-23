package Codility;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Solution1 extends WebDriverTestCase{

	@Test
	public void test() {
		webDriver.get("https://jmeter.apache.org/");
		List<WebElement> ls = webDriver.findElements(By.xpath("//div/ul[3]/li/ul/li/a"));
		
		for(int i=0;i<ls.size();i++) {
			System.out.println(i+1 +" link have href as "+ls.get(i).getAttribute("href"));
			//System.out.println(l.get(i).getAttribute("href"));
		}
		assertEquals(10,ls.size());
		assertEquals(true,ls.size()>1);
		assertTrue(ls.size()>1);
	}

}
