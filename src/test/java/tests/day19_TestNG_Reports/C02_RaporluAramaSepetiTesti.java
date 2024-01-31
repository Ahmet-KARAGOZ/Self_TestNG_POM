package tests.day19_TestNG_Reports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluAramaSepetiTesti extends TestBaseRapor {
	@Test
	public void aramaSepetiTesti(){

		extentTest = extentReports.createTest("arama sepeti Testi" , "sepete attığımız urun ismi ile sepetteki ürün ismi aynı olmalı");

		//1- https://www.testotomasyonu.com/ anasayfasina gidin
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		extentTest.info("Testotomasyonu anasayfaya gider");

		//2- phone icin arama yapin
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);
		extentTest.info("phone için arama yapar.");

		// 3- Listelenen sonuclardan ilkini tiklayin
		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
		extentTest.info("Listeden ilk ürünü tıklar");

		//4- urun ismini kaydedin ve sepete ekleyin
		String sayfadakiUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();
		testOtomasyonPage.urunSayfasiAddToCartButonu.click();
		extentTest.info("ürün ismini kaydeder sepete ekler");

		//5- your cart linkine tiklayin
		testOtomasyonPage.yourCardButonu.click();
		extentTest.info("your card linkine tıklar.");

		//6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
		String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();

		Assert.assertEquals(sepettekiUrunIsmi,sayfadakiUrunIsmi);
		extentTest.pass("kaydedilen ürün ismi ile sepettekini test eder.");

		//7- sayfayi kapatin
		Driver.quitDriver();
		extentTest.info("sayfayı kapatır");
	}
}
