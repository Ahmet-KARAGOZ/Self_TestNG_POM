package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class C04_DepensOnMethods {
	List<WebElement> bulunanUrunElementleriList;

	@Test(priority = 1)
	public void testOtomasyonAnaSayfaTesti(){
		Driver.getDriver().get("https://www.testotomasyonu.com/");
		String expURL = "https://www.testotomasyonu.com/";
		String actURL = Driver.getDriver().getCurrentUrl();
		Assert.assertEquals(actURL,expURL);
	}

	@Test (priority = 2)
	public void aramaTesti(){
		WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone" , Keys.ENTER);

		bulunanUrunElementleriList = Driver.getDriver().findElements(By.xpath("//*[@*='product-box my-2  py-1']"));
		Assert.assertTrue(bulunanUrunElementleriList.size()>0);


	}
	@Test (priority = 3)
	public void ilkUrunIsimTesti(){
		bulunanUrunElementleriList.get(0).click();
		WebElement urunIsmi = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
		String expUrunIsimIcerigi = "phone";
		String actUrunIsmiKucukHarf = urunIsmi.getText().toLowerCase(Locale.ROOT);
		Assert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerigi));

		Driver.quitDriver();
	}
}
