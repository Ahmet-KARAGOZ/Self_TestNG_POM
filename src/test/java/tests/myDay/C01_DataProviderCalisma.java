package tests.myDay;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

//listedeki urunlerin sayfada olmadıgını test edin

public class C01_DataProviderCalisma extends TestBaseRapor {
	@DataProvider
	public static Object[][] urunler() {
		String [][] urunler = {{"araba"} , {"motosiklet"} , {"bisiklet"} , {"yat"} , {"phone"}};
		return  urunler;
	}

	@Test(dataProvider = "urunler")
	public void test01(String urun){

		extentTest = extentReports.createTest("Toplu ürün sorgulama testi" , "Listedeki ürünlerin sayfada olmadıgını test eder.");

		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		extentTest.info("Kullanıcı test otomasyon sayfasına gider.");

		testOtomasyonPage.aramaKutusu.sendKeys(urun + Keys.ENTER);
		extentTest.info("sayfada "+urun+" ile arama yapar");

		String expUrunSonucYazisi = ConfigReader.getProperty("toUrunBulunamadiYazisi");
		String actUrunSonucYazisi = testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText();

		Assert.assertEquals(actUrunSonucYazisi , expUrunSonucYazisi);
		extentTest.pass("Sayfada urunun olmadigini kontrol eder.");

		Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");

	}
}
