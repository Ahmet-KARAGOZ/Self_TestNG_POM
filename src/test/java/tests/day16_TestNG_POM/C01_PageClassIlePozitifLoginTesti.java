package tests.day16_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

/*
1- https://www.testotomasyonu.com/ anasayfasina gidin
2- account linkine basin
 3- Kullanici email'i olarak “wise@gmail.com”girin
 4- Kullanici sifresi olarak “12345” girin
 5- Login butonuna basarak login olun
 6- Basarili olarak giris yapilabildigini test edin
 */


public class C01_PageClassIlePozitifLoginTesti {
	@Test(groups = "smoke")
	public void pozitifLoginTesti(){
		Driver.getDriver().get("https://www.testotomasyonu.com/");
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();

		testOtomasyonPage.emailKutusu.sendKeys("wise@gmail.com");
		testOtomasyonPage.passwordKutusu.sendKeys("12345");
		testOtomasyonPage.loginButonu.click();
		Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());

		ReusableMethods.bekle(2);
		Driver.quitDriver();
	}
}
