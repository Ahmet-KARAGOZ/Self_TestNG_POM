package tests.day17_TestNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C05_Assertions {
	@Test
	public void aramaTEsti(){
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

		String expUrl = ConfigReader.getProperty("toUrl") + "/";
		String actUrl = Driver.getDriver().getCurrentUrl();

		Assert.assertEquals(actUrl,expUrl);

		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);


		int expMinUrunSayisi = 3;
		int actUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

		Assert.assertTrue(actUrunSayisi > expMinUrunSayisi);

		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

		String expUrunIsimIcerik = "phone";
		String actUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

		Assert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerik));

		Driver.quitDriver();
	}
}
