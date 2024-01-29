package tests.day17_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

//1- https://www.testotomasyonu.com/ anasayfasina gidin
//2- login linkine basin
// 3- 3 farkli test method’u olusturun.
// - gecerli username, gecersiz password
// - gecersiz username, gecerli password
// - gecersiz username, gecersiz password.
//4- Login butonuna basarak login olun
//5- Basarili olarak giris yapilamadigini test edin
public class C01_NegatifLoginTesti {
	@Test
public void gecersizPasswordTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();

		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
		testOtomasyonPage.loginButonu.click();

		Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
		Driver.quitDriver();
	}
@Test
	public void gecersizEmailTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();

		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
		testOtomasyonPage.loginButonu.click();

		Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
		Driver.quitDriver();
	}

	@Test
	public void gecersizEmailgecersizPasswordTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();

		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
		testOtomasyonPage.loginButonu.click();

		Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
		Driver.quitDriver();
	}

}
