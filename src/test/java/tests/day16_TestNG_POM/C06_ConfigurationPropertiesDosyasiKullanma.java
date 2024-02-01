package tests.day16_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
//1- https://www.testotomasyonu.com/ anasayfasina gidin
//2- account linkine basin
// 3- Kullanici email'i olarak “wise@gmail.com”girin
// 4- Kullanici sifresi olarak “12345” girin
// 5- Login butonuna basarak login olun
// 6- Basarili olarak giris yapilabildigini test edin

public class C06_ConfigurationPropertiesDosyasiKullanma {
	@Test(groups = "regression")
	public void pozitifLoginTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();
		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
		testOtomasyonPage.loginButonu.click();
		Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());

		//ReusableMethods.bekle(2);
		Driver.quitDriver();
	}
}
