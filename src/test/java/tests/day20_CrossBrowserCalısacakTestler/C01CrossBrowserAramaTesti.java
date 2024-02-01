package tests.day20_CrossBrowserCalısacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01CrossBrowserAramaTesti extends TestBaseCross {
	@Test
	public void aramaTesti(){
		driver.get(ConfigReader.getProperty("toUrl"));
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone" , Keys.ENTER);

		WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

		String unExpectedSonucYazisi = "0 Products Found";
		String actualSonucYazisi = aramaSonucElementi.getText();

		Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

		ReusableMethods.bekle(3);

	}
}
