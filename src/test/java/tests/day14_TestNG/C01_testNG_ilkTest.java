package tests.day14_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_testNG_ilkTest extends TestBase {
	@Test(groups = "regression")
	public void test01(){
		driver.get("https://www.testotomasyonu.com");
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone" + Keys.ENTER);

		WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

		String unExpectedSonucYazisi = "0 Products Found";
		String actualSonucYazisi = aramaSonucElementi.getText();

		Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);


	}

}
