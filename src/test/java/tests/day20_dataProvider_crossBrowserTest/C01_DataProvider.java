package tests.day20_dataProvider_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {
	@DataProvider
	public static Object[][] aranacakUrunlerProvider() {

		String [][] aranacakUrunlerArrayi = {{"phone"} , {"java"} , {"dress"} , {"apple"} , {"nutella"} , {"cokokrem"} , {"baby"}};

		return aranacakUrunlerArrayi;
	}

	@Test(dataProvider = "aranacakUrunlerProvider")
	public void topluAramaTesti(String aranacakUrun){

		extentTest = extentReports.createTest("Toplu Arama Testi" , "Verilen Listedeki Tüm Ürünlerin Stokta bulunduğunu Test eder.");

		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		extentTest.info("Kullanıcı TO ana sayfaya gider");


		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
		extentTest.info("arama kutusuna "+ aranacakUrun +" yazar ve arar.");

		String unExpSonucYazisi = "0 Products Found";
		Assert.assertFalse(testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText().equals(unExpSonucYazisi));
		extentTest.pass(aranacakUrun + " aramasında urun bulunabildiğini test eder.");

		Driver.quitDriver();
		extentTest.info("sayfayi kapatır");
	}

}
