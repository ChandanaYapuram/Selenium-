package Codility;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Solution2 extends WebDriverTestCase{

	@Test
	public void test() {
		webDriver.get("http://bing.com");
		assertEquals("Bing",webDriver.getTitle());
	}
	
	@Test
	public void test1() {
		webDriver.findElement(By.name("q")).sendKeys("Codility");
		webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		List<WebElement> ls = webDriver.findElements(By.xpath("//ol[@id='b_results']/li/h2"));
		assertTrue(ls.size()>1);
		assertFalse(ls.size()<0);
	}
}
