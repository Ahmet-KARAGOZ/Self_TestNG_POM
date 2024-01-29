package tests.day17_TestNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
//1- https://www.testotomasyonu.com/ anasayfasina gidin
//2- phone icin arama yapin
// 3- Listelenen sonuclardan ilkini tiklayin
//4- urun ismini kaydedin ve sepete ekleyin
//5- your cart linkine tiklayin
//6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
//7- sayfayi kapatin

public class C02_UrunSepetiTesti {
	@Test
	public void urunSepetiTesti(){
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);

		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
		String urunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();

		testOtomasyonPage.urunSayfasiAddToCartButonu.click();
		testOtomasyonPage.yourCardButonu.click();

		String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();

		Assert.assertEquals(sepettekiUrunIsmi,urunIsmi);
		Driver.quitDriver();

	}
}
