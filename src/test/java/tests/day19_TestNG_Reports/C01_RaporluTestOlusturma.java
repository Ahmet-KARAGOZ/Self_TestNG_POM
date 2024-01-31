package tests.day19_TestNG_Reports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {
	@Test
	public void aramaTesti(){

		extentTest = extentReports.createTest("arama Testi" , "test otomasyonunda phone aranabilmeli");

		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
		extentTest.info("kullanıcı test otomasyonu ana sayfaya gider");

		String expUrl = ConfigReader.getProperty("toUrl") + "/";
		String actUrl = Driver.getDriver().getCurrentUrl();

		//Assert.assertEquals(actUrl,expUrl);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actUrl,expUrl,"URL Testi failed");
		extentTest.info("testotomasyonu sayfassına gittiğini test eder");

		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);
		extentTest.info("phone icin arama yapar.");


		int expMinUrunSayisi = 3;
		int actUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

		//Assert.assertTrue(actUrunSayisi > expMinUrunSayisi);
		softAssert.assertTrue(actUrunSayisi>expMinUrunSayisi,"2. Assertion failed");
		extentTest.info("urun sayısı kontrol eder");

		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
		extentTest.info("ilk ürüne tıklar");

		String expUrunIsimIcerik = "phone";
		String actUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

		//Assert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerik));
		softAssert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerik),"Ürün ismi Testi  failed");
		extentTest.info("Urun ismini test eder");

		softAssert.assertAll();
		extentTest.pass("softassert ile yapılan tum assertionlar raporlanır");

		Driver.quitDriver();
	}
}
